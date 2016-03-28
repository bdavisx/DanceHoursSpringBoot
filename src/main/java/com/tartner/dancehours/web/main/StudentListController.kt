package com.tartner.dancehours.web.main

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

// TODO: I'm not sure that this belongs here (in this package), but we'll see
// how things pan out

@RestController
open class StudentListController @Autowired constructor() {
    @RequestMapping(path=arrayOf("/studentList"),
        method=arrayOf(RequestMethod.GET))
    fun list(): List<StudentListData> {
        val studentList = listOf(
            StudentListData( "abc", "Student 1", listOf(
                HoursDonatedData("Your Hours", 5),
                HoursDonatedData("Others", 2),
                HoursDonatedData("Remaining", 5, true)
            ), 12),
            StudentListData( "def", "Student 2", listOf(
                HoursDonatedData("Your Hours", 4),
                HoursDonatedData("Remaining", 6, true)
            ), 10)
        )
        return studentList;
    }

}

data class StudentListData(
    val id: String,
    val name: String,
    val hoursDonated: List<HoursDonatedData>,
    val totalHoursNeeded: Int
)

data class HoursDonatedData(
    val name: String,
    val howManyHours: Int,
    val remaining: Boolean = false
)

