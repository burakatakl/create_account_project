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

    @Test
    fun testFullName() {
        assertTrue(credentialsManager.validFullName("Burak Atakli"))
        assertFalse(credentialsManager.validFullName(" "))
        assertTrue(credentialsManager.validFullName("Burak"))
    }

    @Test
    fun testPhoneNumber() {
        assertTrue(credentialsManager.validPhoneNumber("4643732829"))
        assertFalse(credentialsManager.validPhoneNumber("987"))
        assertFalse(credentialsManager.validPhoneNumber(" "))
    }

    @Test
    fun testCredentialsSignUpPage() {
        assertTrue(
            credentialsManager.validateCredentialsForSignUp(
                "Burak Atakli", "burak@test.com", "4643732829", "burak123", true
            )
        )
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "", "burak@test.com", "4643732829", "burak123", true
            )
        )
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "Burak Atakli", "burak@test.com", "987", "burak123", true
            )
        )
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "Burak Atakli","burak@test.com","4643732829","no",true
            )
        )
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "Burak Atakli","false_email","4643732829","burak123",true
            )
        )
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "Burak Atakli","burak@test.com","4643732829","burak123",false
            )
        )
    }
    @Test
    fun testMistakeCredentials(){
        val valueEmail = "burak@tt.omc"
        val valuePasswords = "b123"
        assertTrue(valueEmail == "burak@tt.omc" && valuePasswords == "b123")
        assertFalse(valueEmail =="false@tt.omc" && valuePasswords == "b123")
        assertFalse(valueEmail=="burak@tt.omc"&& valuePasswords =="false")
    }


}