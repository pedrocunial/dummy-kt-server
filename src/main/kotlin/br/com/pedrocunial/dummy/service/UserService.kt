package br.com.pedrocunial.dummy.service

import br.com.pedrocunial.dummy.dto.UserDTO
import br.com.pedrocunial.dummy.model.User
import br.com.pedrocunial.dummy.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun createUser(userDTO: UserDTO): User = createUser(userDTO.name, userDTO.phone)

    fun createUser(name: String, phone: String?): User {
        val user = User(name = name, phone = phone)
        userRepository.save(user)

        return user
    }

    fun fetchById(id: Long): User? {
        val user = userRepository
                .findById(id)
                .orElse(null)

        return user
    }
}
