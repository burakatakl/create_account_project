import com.example.create_account_project.CredentialsManager
import org.junit.Assert.*
import org.junit.Test


class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()

    @Test
    fun testValidEmail() {
        assertTrue(credentialsManager.emailValid("example@email.com"))
        assertFalse(credentialsManager.emailValid("false_email"))
    }

    @Test
    fun testPassword() {
        assertTrue(credentialsManager.validPassword("burak123"))
        assertFalse(credentialsManager.validPassword("no"))
    }

    @Test
    fun testCredentials() {
        assertTrue(credentialsManager.validateCredentials("burak@test.com", "burak123"))
        assertFalse(credentialsManager.validateCredentials("false_email", "burak123"))
        assertFalse(credentialsManager.validateCredentials("burak@test.com", "no"))

        assertFalse(credentialsManager.validateCredentials("burak@test.com", "burak123"))
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
        assertTrue(credentialsManager.isValidPhoneNumber("4643732829"))
        assertFalse(credentialsManager.isValidPhoneNumber("987"))
        assertFalse(credentialsManager.isValidPhoneNumber(" "))
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