import com.example.create_account_project.CredentialsManager
import org.junit.Assert.*
import org.junit.Test


class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()

    @Test
    fun testValidEmail(){
        assertTrue(credentialsManager.isEmailValid("example@email.com"))
        assertFalse(credentialsManager.isEmailValid("false_email"))
    }
    @Test
    fun testPassword(){
        assertTrue(credentialsManager.isValidPassword("burak123"))
        assertFalse(credentialsManager.isValidPassword("no"))
    }



}