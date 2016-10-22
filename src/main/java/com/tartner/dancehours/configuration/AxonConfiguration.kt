package com.tartner.dancehours.web.config

import com.tartner.utilities.IdentifierFactory
import com.tartner.utilities.SequentialIdentifierFactory
import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.annotation.AnnotationCommandHandlerBeanPostProcessor
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.commandhandling.gateway.DefaultCommandGateway
import org.axonframework.contextsupport.spring.AnnotationDriven
import org.axonframework.eventhandling.EventBus
import org.axonframework.eventhandling.SimpleEventBus
import org.axonframework.eventhandling.annotation.AnnotationEventListenerBeanPostProcessor
import org.axonframework.eventstore.EventStore
import org.axonframework.eventstore.jdbc.JdbcEventStore
import org.axonframework.unitofwork.DefaultUnitOfWorkFactory
import org.axonframework.unitofwork.SpringTransactionManager
import org.axonframework.unitofwork.TransactionManager
import org.axonframework.unitofwork.UnitOfWorkFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import javax.sql.DataSource

@Configuration
@AnnotationDriven
open class AxonConfiguration {
    @Autowired private var dataSource: DataSource? = null
    @Autowired private var platformTransactionManager: PlatformTransactionManager? = null

    @Bean
    public open fun guidGenerator(): IdentifierFactory { return SequentialIdentifierFactory() }

    @Bean
    public open fun eventBus(): EventBus { return SimpleEventBus() }

    @Bean
    public open fun commandBus(): CommandBus { return SimpleCommandBus() }

    @Bean
    public open fun commandGateway(): CommandGateway { return DefaultCommandGateway(commandBus()) }

    @Bean
    public open fun eventStore(): EventStore {
        val eventStore = JdbcEventStore(dataSource)
        return eventStore
    }

    @Bean
    public open fun annotationEventListenerBeanPostProcessor(): AnnotationEventListenerBeanPostProcessor {
        val postProcessor = AnnotationEventListenerBeanPostProcessor()
        postProcessor.setEventBus(eventBus())
        return postProcessor
    }

    @Bean
    public open fun annotationCommandHandlerBeanPostProcessor(): AnnotationCommandHandlerBeanPostProcessor {
        val postProcessor = AnnotationCommandHandlerBeanPostProcessor()
        postProcessor.setCommandBus(commandBus())
        return postProcessor
    }

    @Bean
    public open fun unitOfWorkFactory(): UnitOfWorkFactory {
        val factory = DefaultUnitOfWorkFactory(axonTransactionManager())
        return factory
    }

    @Bean
    public open fun axonTransactionManager(): TransactionManager<TransactionStatus> {
        val transactionManager = SpringTransactionManager(platformTransactionManager)
        return transactionManager
    }
}
