package interview.upendra.com.basicstructurekotlin

class SongInfo {


    var songName: String? = null;
    var artistName: String? = null
    var description: String? = null
    var image: Int? = null

    constructor(songName: String, artistName: String, description: String, image: Int) {

        this.songName = songName
        this.artistName = artistName
        this.description = description
        this.image = image

    }
}