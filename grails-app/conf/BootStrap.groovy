import com.ig.linksharing.User

class BootStrap {

    def init = { servletContext ->
        User user = User.findOrCreateById(1)
        user.email='admin@intelligrape.com'
        user.password = 'admin'
        user.save()

        user = User.findOrCreateById(2)
        user.email='parampreet.singh@intelligrape.com'
        user.password = 'igdefault'
        user.save()

    }
    def destroy = {
    }
}
