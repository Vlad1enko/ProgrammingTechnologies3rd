package ua.kpi.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.library.exception.BookNotFoundException;
import ua.kpi.library.model.Library;
import ua.kpi.repository.LibraryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryService bookService;

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public Library getLibraryById(Integer id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public List<Library> getLibraries() {
        return libraryRepository.findAll();
    }

    @Override
    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library updateLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public void deleteLibraryById(Integer id) {
        try {
            libraryRepository.deleteById(id);
        } catch (Exception exception) {
            throw new BookNotFoundException(id);
        }
    }
//
//    @Override
//    public List<Library> getLibrarysOfAuthor(Author author) {
//        return of(author)
//                .map(a -> bookService.getLibrarys().stream()
//                        .filter(book -> book.getAuthor().equals(a))
//                        .collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
//                            if ( result.isEmpty()) {
//                                throw new LibraryNotFoundException(author);
//                            }
//                            return result;
//                        }))
//                ).orElseThrow(() -> new RuntimeException("Exception that should never have happened"));
//    }
//
//    @Override
//    public Library getLibraryById(Integer id) {
//        return bookService.getLibraryById(id);
//    }
//
//    @Override
//    public List<Library> getLibrarysOfTheSameGenre(Library book) {
//        return of(book)
//                .map(b -> bookService.getLibrarys().stream()
//                        .filter(bookFilter -> bookFilter.getGenre().equals(b.getGenre()))
//                        .collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
//                            Collections.shuffle(collected);
//                            return collected.stream();
//                        }))
//                        .limit(5)
//                        .collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
//                            if ( result.isEmpty()) {
//                                throw new LibraryNotFoundException(book.getGenre());
//                            }
//                            return result;
//                        }))
//                ).orElseThrow(() -> new RuntimeException("Exception that should never have happened"));
//    }
//
//    @Override
//    public Library getLibraryByTitle(String title) {
//        return bookService.getLibraryByTitle(title);
//    }
//
//    public List<Library> getLibrarys(){
//        return bookService.getLibrarys();
//    }
//
//    public Library createLibrary( Author authorNew, String titleNew, int yearNew, String publisherNew, double costNew, LibraryGenreEnum genre) {
//        return bookService.createLibrary(authorNew, titleNew, yearNew, publisherNew, costNew, genre);
//    }
//
//    public Author createAuthor(String name, String surname, String dob) {
//        return new Author(name, surname, dob);
//    }
//
//    public Author createAuthor(String name, String surname) {
//        return new Author(name, surname);
//    }
//
//    public Library updateLibraryById(Library book) {
//        return bookService.updateLibraryById(book);
//    }
//
//    public LibraryService setLibraryService(LibraryService bookService) {
//        this.bookService = bookService;
//        return this;
//    }
}
