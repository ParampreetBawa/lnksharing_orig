import com.ig.linksharing.CommonUtility
import com.ig.linksharing.User

class BootStrap {

    def init = { servletContext ->
        User user = User.findOrCreateById(1)
        user.email='admin@intelligrape.com'
        user.password = CommonUtility.encrypt('admin')
        user.confirmPassword = user.password
        user.date = new Date()
        user.save(failOnError: true)

        user = User.findOrCreateById(2)
        user.email='parampreet.singh@intelligrape.com'
        user.password = CommonUtility.encrypt('test')
        user.confirmPassword = user.password
        user.date = new Date()
        user.save(failOnError: true)

    }
    def destroy = {
    }
}
