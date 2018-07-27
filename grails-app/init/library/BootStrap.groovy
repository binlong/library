package library

class BootStrap {

    def init = {
        def adminRole = new Role(authority: 'ROLE_WRITE').save()
        def admin = new User(username: 'admin', password: 'admin').save()

        UserRole.create admin, adminRole
        UserRole.withSession {
            it.flush()
            it.clear()
        }

        new Book(title: 'Book', author: 'John Smith').save()

        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1
        assert Book.count() == 1
    }
    def destroy = {
    }
}
