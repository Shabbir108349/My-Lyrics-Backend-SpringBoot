package com.shabbir.stream;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Repository extends MongoRepository<Song, ObjectId> {
    Song findBySongId(String id);
    List<Song> findByPopular(boolean b);

    @Query("{ $or: [ " +
            "{ 'title': { $regex: ?0, $options: 'i' } }, " +
            "{ 'artist': { $regex: ?0, $options: 'i' } }, " +
            "{ 'genre': { $regex: ?0, $options: 'i' } }, " +
            "{ 'language': { $regex: ?0, $options: 'i' } } " +
            "] }")
    List<Song> searchSongs(String keyword);

}
