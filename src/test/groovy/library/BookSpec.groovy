package library

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BookSpec extends Specification implements DomainUnitTest<Book> {
    void "test Book domain constraints"() {
        when: 'A Book is saved with invalid data'
        Book invalidBook = new Book(title: title, author: author)
        invalidBook.save()

        then: 'Errors occurs and book was not saved'
        invalidBook.hasErrors() == expectedErrors
        for (String fieldError : expectedFieldError) {
            invalidBook.errors.getFieldError(fieldError)
        }
        invalidBook.count() == count

        where:
        title   | author | count | expectedTitle | expectedAuthor | expectedFieldError       | expectedErrors
        'Valid' | ''     |   0   |      null     |      null      |     ['author']           |  true
        'Valid' | null   |   0   |      null     |      null      |     ['author']           |  true
        ''      | 'Valid'|   0   |      null     |      null      |     ['title']            |  true
        null    | 'Valid'|   0   |      null     |      null      |     ['title']            |  true
        null    | null   |   0   |      null     |      null      |     ['author', 'title']  |  true
        'Valid' | 'Valid'|   1   |      'Valid'  |      'Valid'   |     []                   |  false

    }
}
