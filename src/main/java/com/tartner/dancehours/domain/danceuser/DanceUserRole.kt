package com.tartner.dancehours.domain.danceuser

// TODO: make data driven
public enum class DanceUserRole private constructor(
    public val roleText : String, public val displayName: String) {

    Administrator("Administrator", "Administrator"),
    ParentGuardian("Parent/Guardian", "Parent/Guardian"),
    CompanyMember("SeniorCompany", "Senior Company Member"),
    JuniorCompanyMember("JuniorCompany", "Junior Company Member"),
    ApprenticeCompanyMember("ApprenticeCompany", "Apprentice Company Member"),
    PerformanceCompanyMember("PerformanceCompany", "Performance Company Member")
}
