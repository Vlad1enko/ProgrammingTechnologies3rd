package ua.kpi.library.service;

import ua.kpi.library.model.Library;

import java.util.List;

public interface LibraryService {
    Library getLibraryById(Integer id);
    List<Library> getLibraries();
    Library createLibrary(Library library);
    Library updateLibrary(Library library);
    void deleteLibraryById(Integer id);
}
