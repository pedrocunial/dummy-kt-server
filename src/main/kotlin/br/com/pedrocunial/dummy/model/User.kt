package br.com.pedrocunial.dummy.model

import javax.persistence.*

@Entity
@Table(name = "person")
data class User(
        @Column(nullable = false)
        val name: String,

        @Column(nullable = true)
        val phone: String?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
}
