package library

import grails.rest.*

class BookController extends RestfulController {
    static responseFormats = ['json', 'xml']
    BookController() {
        super(Book)
    }

    def search() {
        if (params.title && params.author) {
            def bookList = Book.where {
                title == params.title && author == params.author
            }
            respond bookList.list()
        }
        else if (params.title) {
            def bookList = Book.where {
                title == params.title
            }
            respond bookList.list()
        }
        else if (params.author) {
            def bookList = Book.where {
                author == params.author
            }
            respond bookList.list()
        }
        else {
            respond (Book.list())
        }
    }
}
