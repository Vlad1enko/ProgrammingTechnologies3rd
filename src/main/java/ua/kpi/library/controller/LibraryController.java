package ua.kpi.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.library.model.Library;
import ua.kpi.library.service.LibraryService;

@RestController
@RequestMapping(value = "/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public void createLibrary(@RequestBody Library library) {
        libraryService.createLibrary(library);
    }

    @GetMapping("/{libraryId}")
    public Library getLibraryById(@PathVariable Integer libraryId) {
        return libraryService.getLibraryById(libraryId);
    }

    @PutMapping
    public void updateLibrary(@RequestBody Library library) {
        libraryService.updateLibrary(library);
    }

    @DeleteMapping("/{libraryId}")
    public void deleteLibrary(@PathVariable Integer libraryId) {
        libraryService.deleteLibraryById(libraryId);
    }
}
