package com.silvionetto.lfn

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
}

@Repository
interface CategoryRepository : CrudRepository<Category, Long> {
    fun findByName(name: String): Category?
}

@Repository
interface SubCategoryRepository : CrudRepository<SubCategory, Long> {
    fun findByNameAndCategory(name: String, category: Category): SubCategory?
}
