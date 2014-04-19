import com.ig.linksharing.User

class BootStrap {

    def init = { servletContext ->
        User user = User.findOrSaveById(1)
        user.email='admin@intelligrape.com'
        user.password = 'admin'
        user.save()
    }
    def destroy = {
    }
}
