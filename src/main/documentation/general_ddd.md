Remember to define your business repository in terms of the business, then implement the
interface in the Database layer.

So: DanceUserAggregateRepository: Find(id): DanceUserAggregate

    * If this is a domain object (DanceUserAggregate) and it's using a JPA entity for backing, then
    it seems that we're still tying ourselves to JPA?

    * If we're going to go with a "pure" Domain object (no JPA backing), then we're going to have
     to do some serious translation between the two
