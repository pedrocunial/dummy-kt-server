package br.com.pedrocunial.dummy.it

import br.com.pedrocunial.dummy.model.User
import br.com.pedrocunial.dummy.repository.UserRepository
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class UserIT {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun testCreateUser() {
        val userName = "roberto"
        val userPhone = "1245667"
        val user = User(userName, userPhone)

        val savedUser = userRepository.save(user)

        val result = testRestTemplate.getForEntity("/user/" + savedUser.id, User::class.java)

        assertThat(result, `is`(IsNull.notNullValue()))
        assertThat(result.body?.name, equalTo(user.name))
        assertThat(result.body?.phone, equalTo(user.phone))
    }
}
