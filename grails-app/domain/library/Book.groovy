package library

import org.grails.datastore.gorm.GormEntity

class Book implements GormEntity<Book> {
    String title
    String author

    static constraints = {
        title blank: false, nullable: false
        author blank: false, nullable: false
    }
}
