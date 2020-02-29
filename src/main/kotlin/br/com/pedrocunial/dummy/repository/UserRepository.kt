package br.com.pedrocunial.dummy.repository

import br.com.pedrocunial.dummy.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
}
