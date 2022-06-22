package com.example.finalproject.application.movies;

import com.example.finalproject.api.exception.NotFoundException;
import com.example.finalproject.application.files.FileEntity;
import com.example.finalproject.core.file.FileRepository;
import com.example.finalproject.core.movies.Movies;
import com.example.finalproject.core.movies.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    FileRepository fileRepository;

    @Transactional
    public Movies create(MovieCreateParam movieCreateParam, MultipartFile file) throws IOException {
        String fileId = UUID.randomUUID().toString();
        FileEntity newFile = new FileEntity(fileId, StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())), file.getContentType(), file.getSize(), file.getBytes());
        fileRepository.save(newFile);
        Movies movies = new Movies(movieCreateParam.getMovie_name()
                , movieCreateParam.getPremiere_date()
                , movieCreateParam.getDetail()
                , movieCreateParam.getTrailer_link()
                , movieCreateParam.getImage_path()
                , movieCreateParam.getTime(),
                fileId);
        moviesRepository.save(movies);
        return movies;
    }

    public Movies update(MovieCreateParam movieCreateParam, MultipartFile file, String id) throws NotFoundException, IOException {
        Movies movie = moviesRepository.findById(id);
        if (movie != null) {
            String fileId = "";
            if (!Objects.equals(file.getOriginalFilename(), "")) {
                fileId = UUID.randomUUID().toString();
                FileEntity deleteFile = new FileEntity(movie.getImage_id(), StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())), file.getContentType(), file.getSize(), file.getBytes());
                fileRepository.delete(deleteFile);
                FileEntity newFile = new FileEntity(fileId, StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())), file.getContentType(), file.getSize(), file.getBytes());
                fileRepository.save(newFile);
            } else {
                fileId = movie.getImage_id();
            }
            Movies movies = new Movies(id
                    , movieCreateParam.getMovie_name()
                    , movieCreateParam.getPremiere_date()
                    , movieCreateParam.getDetail()
                    , movieCreateParam.getTrailer_link()
                    , movieCreateParam.getImage_path()
                    , movieCreateParam.getTime(),
                    fileId);
            moviesRepository.delete(movie.getId());
            moviesRepository.save(movies);
        } else {
            throw new NotFoundException("Phim không tồn tại");
        }
        return moviesRepository.findById(id);
    }

    public Movies updateWithoutFile(MovieCreateParam movieCreateParam, String id) throws NotFoundException {
        Movies movie = moviesRepository.findById(id);
        if (movie != null) {
            Movies movies = new Movies(id
                    , movieCreateParam.getMovie_name()
                    , movieCreateParam.getPremiere_date()
                    , movieCreateParam.getDetail()
                    , movieCreateParam.getTrailer_link()
                    , movieCreateParam.getImage_path()
                    , movieCreateParam.getTime(),
                    movie.getImage_id());
            moviesRepository.delete(movie.getId());
            moviesRepository.save(movies);
        } else {
            throw new NotFoundException("Phim không tồn tại");
        }
        return moviesRepository.findById(id);
    }

    public byte[] getImage(String id) {
        return fileRepository.findById(id).get().getData();
    }


    public MoviesList getMovies() {
        ArrayList<Movies> moviesArrayList;
        ArrayList<Movies> moviesAboutOnAir = new ArrayList<>();
        ArrayList<Movies> moviesOnAir = new ArrayList<>();
        moviesArrayList = moviesRepository.getMovies();

        for (Movies movies : moviesArrayList) {
            Date now = new Date();
            if (movies.getPremiere_date().before(now) || movies.getPremiere_date().equals(now)) {
                moviesOnAir.add(movies);
            } else if (movies.getPremiere_date().after(now)) {
                moviesAboutOnAir.add(movies);
            }
        }
        for (Movies movie : moviesAboutOnAir) {
            if (movie.getImage_id() != null) {
                movie.setImage_path("http://localhost:8080/movies/file/" + movie.getImage_id());
            } else {
                movie.setImage_path("http://localhost:8080/movies/file/1a981425-6a4a-47e2-890b-61bcaae870a8");
            }
        }

        for (Movies movie : moviesOnAir) {
            if (movie.getImage_id() != null) {
                movie.setImage_path("http://localhost:8080/movies/file/" + movie.getImage_id());
            } else {
                movie.setImage_path("http://localhost:8080/movies/file/1a981425-6a4a-47e2-890b-61bcaae870a8");
            }
        }


        MoviesList moviesList = new MoviesList(moviesAboutOnAir, moviesOnAir);

        return moviesList;
    }

    public Movies getMovieById(String id) {
        Movies movie = moviesRepository.findById(id);
        if (movie.getImage_id() != null) {
            movie.setImage_path("http://localhost:8080/movies/file/" + movie.getImage_id());
        } else {
            movie.setImage_path("http://localhost:8080/movies/file/1a981425-6a4a-47e2-890b-61bcaae870a8");
        }
        return movie;
    }

    public List<Movies> getAll() {
        List<Movies> moviesList = moviesRepository.getAll();
        for (Movies movie : moviesList) {
            if (movie.getImage_id() != null) {
                movie.setImage_path("http://localhost:8080/movies/file/" + movie.getImage_id());
            } else {
                movie.setImage_path("http://localhost:8080/movies/file/1a981425-6a4a-47e2-890b-61bcaae870a8");
            }
        }
        return moviesList;
    }

    public List<Movies> filter(String query) {
        return moviesRepository.filter(query);
    }

    public void delete(String id) {
        moviesRepository.delete(id);
    }
}
