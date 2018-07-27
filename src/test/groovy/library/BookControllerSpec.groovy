package library

import grails.plugin.json.view.mvc.JsonViewResolver
import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class BookControllerSpec extends Specification implements ControllerUnitTest<BookController>, DomainUnitTest<Book> {

    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    void setup() {
        Book.saveAll(
                new Book(title: 'Test Title', author: 'Test Author'),
                new Book(title: 'Book', author: 'John Smith')
        )
    }

    void 'test the search action'() {
        setup:
        controller.params.clear()
        if (title) {
            controller.params.put('title', title)
        }
        if (author) {
            controller.params.put('author', author)
        }

        when: 'Title and author is provided'
        controller.search()

        then: 'The response is correct'
        response.json.size() == expectedSize
        if (expectedSize == 1) {
            response.json[0].title == expectedTitle
            response.json[0].author == expectedAuthor
        }

        where:
        title << ['Test Title', 'Book', null, null]
        author << ['Test Author', null, 'John Smith', null]
        expectedSize << [1, 1, 1, 2]
        expectedTitle << ['Test Title', 'Book', 'Book', null]
        expectedAuthor << ['Test Author', 'John Smith', 'John Smith', null]
    }
}
