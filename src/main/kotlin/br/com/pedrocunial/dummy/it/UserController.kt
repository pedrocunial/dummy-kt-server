package br.com.pedrocunial.dummy.it

import br.com.pedrocunial.dummy.dto.UserDTO
import br.com.pedrocunial.dummy.model.User
import br.com.pedrocunial.dummy.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/{id}", produces = ["application/json"])
    fun getUser(@PathVariable id: Long): User? = userService.fetchById(id)

    @PostMapping
    fun createUser(@RequestBody userDTO: UserDTO): User = userService.createUser(userDTO)
}
