import com.example.create_account_project.CredentialsManager
import org.junit.Assert.*
import org.junit.Test


class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()

    @Test
    fun testValidEmail() {
        assertTrue(credentialsManager.isEmailValid("example@email.com"))
        assertFalse(credentialsManager.isEmailValid("false_email"))
    }

    @Test
    fun testPassword() {
        assertTrue(credentialsManager.isValidPassword("burak123"))
        assertFalse(credentialsManager.isValidPassword("no"))
    }

    @Test
    fun testCredentials() {
        assertTrue(credentialsManager.validateCredentials("burak@test.com", "burak123", true))
        assertFalse(credentialsManager.validateCredentials("false_email", "burak123", true))
        assertFalse(credentialsManager.validateCredentials("burak@test.com", "no", true))

        assertFalse(credentialsManager.validateCredentials("burak@test.com", "burak123", false))
    }

    @Test
    fun testTermsAccepted() {
        assertFalse(credentialsManager.termsAccepted(false))
    }


}