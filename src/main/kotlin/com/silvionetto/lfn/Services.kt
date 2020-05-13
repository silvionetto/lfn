package com.silvionetto.lfn

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun save(user: User): User {
        if (userRepository.findByLogin(user.login) == null) {
            return userRepository.save(user)
        }
        return user
    }
}

@Service
class CategoryService {

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    fun findByName(name: String): Category {
        return categoryRepository.findByName(name) ?: Category("Category", mutableListOf<Category>())
    }

    fun save(category: Category): Category {
        if (categoryRepository.findByName(category.name) == null) {
            return categoryRepository.save(category)
        }
        return category
    }

    fun findAll(): MutableIterable<Category> {
        return categoryRepository.findAll()
    }
}

@Service
class SubCategoryService {

    @Autowired
    lateinit var subCategoryRepository: SubCategoryRepository

    fun save(subCategory: SubCategory, category: Category): SubCategory {
        if (subCategoryRepository.findByNameAndCategory(subCategory.name, category) == null) {
            return subCategoryRepository.save(subCategory)
        }
        return subCategory
    }
}
