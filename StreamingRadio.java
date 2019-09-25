package cs445.a4;

/**
 * This abstract data type represents the backend for a streaming radio service.
 * It stores the songs, stations, and users in the system, as well as the
 * ratings that users assign to songs.
 */
public interface StreamingRadio {

    /**
     * The abstract methods below are declared as void methods with no
     * parameters. You need to expand each declaration to specify a return type
     * and parameters, as necessary. You also need to include a detailed comment
     * for each abstract method describing its effect, its return value, any
     * corner cases that the client may need to consider, any exceptions the
     * method may throw (including a description of the circumstances under
     * which this will happen), and so on. You should include enough details
     * that a client could use this data structure without ever being surprised
     * or not knowing what will happen, even though they haven't read the
     * implementation.
     */

    /**
     * Adds a new song to the system.  Adds song to system's data structure.
     * If the song is null, a NullPointerException will be thrown instead of
     * adding it to the system.  If the song to add is already in the system's 
     * data structure or if the system is already full, throw IllegalArgumentException.
     * 
     * @param theSong the song to add to the system
     * @throws NullPointerException if song is null
     * @throws IllegalArgumentException if the song to add is already in the system, or system array full
     */
    public void addSong(Song theSong) throws NullPointerException, IllegalArgumentException;

    /**
     * Removes an existing song from the system. Removes song from the system's data structure.
     * Returns the removed song to the user.  If the specified song to remove is null, 
     * throw a NullPointerException.  If the specified song is not in the system's data 
     * structure, throw an IllegalArgumentException.
     * 
     * @param theSong the song to remove from the system
     * @return the removed song
     * @throws NullPointerException if the song to remove is null
     * @throws IllegalArgumentException if the specified song is not in the system
     */
    public Song removeSong(Song theSong) throws NullPointerException, IllegalArgumentException;

    /**
     * Adds an existing song to the playlist for an existing radio station.
     * Adds the song to the station.  If the song or the station is null, 
     * throw NullPointerException.  If the song is already on the playlist 
     * or if the playlist array is already full, throw IllegalArgumentException.
     * 
     * @param theSong the song to be added to the playlist
     * @param theStation the playlist that is being added too
     * @throws NullPointerException if either the song or the playlist are null
     * @throws IllegalArgumentException if the song is already in the playlist, or playlist array is already full
     */
    public void addToStation(Song theSong, Station theStation) throws NullPointerException, IllegalArgumentException;

    /**
     * Removes a song from the playlist for a radio station. Removes the song
     * from the station.  Return the removed song to the user.  If the song 
     * or the station is null, throw NullPointerException.  If the specified 
     * song or station is not in the system, throw IllegalArgumentException.
     * 
     * @param theSong the song to be removed from the playlist
     * @param theStation the playlist that the song is being removed from
     * @return the removed song
     * @throws NullPointerException if either the song or the playlist are null
     * @throws IllegalArgumentException if the specified song or station are not in the data structure
     */
    public Song removeFromStation(Song theSong, Station theStation) throws NullPointerException, IllegalArgumentException;

    /**
     * Sets a user's rating for a song, as a number of stars from 1 to 5.
     * The rating for the song (between 1 and 5) is saved to the user for
     * the specified song.  If the user or the song is null, throw NullPointerException.
     * If the user or the song is not in the system, throw IllegalArgumentException.
     * 
     * @param theUser the user who is rating the song
     * @param theSong the song being rated
     * @param theRating the rating of the song, integer between 1 and 5
     * @throws NullPointerException if the user or song is null
     * @throws IllegalArgumentException if the specified user or song is not in the system
     */
    public void rateSong(User theUser, Song theSong, int theRating) throws NullPointerException, IllegalArgumentException;

    /**
     * Clears a user's rating on a song. If this user has rated this song and
     * the rating has not already been cleared, then the rating is cleared and
     * the state will appear as if the rating was never made. If there is no
     * such rating on record (either because this user has not rated this song,
     * or because the rating has already been cleared), then this method will
     * throw an IllegalArgumentException.
     *
     * @param theUser user whose rating should be cleared
     * @param theSong song from which the user's rating should be cleared
     * @throws IllegalArgumentException if the user does not currently have a
     * rating on record for the song
     * @throws NullPointerException if either the user or the song is null
     */
    public void clearRating(User theUser, Song theSong)
    throws IllegalArgumentException, NullPointerException;

    /**
     * Predicts the rating a user will assign to a song that they have not yet
     * rated, as a number of stars from 1 to 5.  Check the user's previous ratings
     * and the current song to predict what the current song's rating will be.  Return
     * the predicted rating as an integer value.  If the user has no previously rated 
     * songs, then return 3 (an average score).  If the user or the song is null, 
     * throw NullPointerException.  If the user or the song is not in the system, 
     * throw IllegalArgumentException.
     * 
     * @param theUser the user who's rating is being predicted
     * @param theSong the song which is having its rating predicted
     * @return the predicted number of stars as an integer between 1 and 5, 3 if no previously rated songs
     * @throws NullPointerException if the user or the song are null
     * @throws IllegalArgumentException if the user or the song are not in the system
     */
    public int predictRating(User theUser, Song theSong) throws NullPointerException, IllegalArgumentException;

    /**
     * Suggests a song for a user that they are predicted to like.  Check the
     * user's previous song ratings and suggest a song that is similar to the
     * that have been highly rated by the user.  Return the suggested song to
     * the user.  If the user does not have any previous songs to suggest a new
     * song against, then return any song.  If the user is null, 
     * throw NullPointerException.  If the user is not in the system, throw 
     * IllegalArgumentException.
     * 
     * @param theUser the user who's going to have a song suggested to them
     * @return the suggested song
     * @throws NullPointerException if the user is null
     * @throws IllegalArgumentException if the user is not in the system
     */
    public Song suggestSong(User theUser) throws NullPointerException, IllegalArgumentException;

}

