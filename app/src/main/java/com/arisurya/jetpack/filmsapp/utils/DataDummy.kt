package com.arisurya.jetpack.filmsapp.utils

import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.data.source.remote.response.DetailMovieResponse
import com.arisurya.jetpack.filmsapp.data.source.remote.response.DetailTvShowResponse
import com.arisurya.jetpack.filmsapp.data.source.remote.response.ResultsItemMovie
import com.arisurya.jetpack.filmsapp.data.source.remote.response.ResultsItemTvShow

object DataDummy {

    fun generateDummyMovies(): List<FilmEntity> {
        val movies = ArrayList<FilmEntity>()
        movies.add(
            FilmEntity(
                "460465",
                "Mortal Kombat",
                7.7,
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                false,
                "1h 50m",
                "2021-04-07",
                "en",
                "https://www.themoviedb.org/t/p/w185/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "https://www.themoviedb.org/movie/460465"
            )
        )

        movies.add(
            FilmEntity(
                "399566",
                "Godzilla vs. Kong",
                8.1,
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                false,
                "1h 53m",
                "2021-03-24",
                "en",
                "https://www.themoviedb.org/t/p/w185/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "https://www.themoviedb.org/movie/399566"
            )
        )

        movies.add(
            FilmEntity(
                "615457",
                "Nobody",
                8.5,
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                false,
                "1h 32m",
                "2021-03-26",
                "en",
                "https://www.themoviedb.org/t/p/w185/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "https://www.themoviedb.org/movie/615457"
            )
        )

        movies.add(
            FilmEntity(
                "567189",
                "Tom Clancy's Without Remorse",
                7.3,
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                false,
                "1h 49m",
                "2021-04-29",
                "en",
                "https://www.themoviedb.org/t/p/w185/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "https://www.themoviedb.org/movie/567189"
            )
        )

        movies.add(
            FilmEntity(
                "804435",
                "Vanquish",
                6.4,
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                false,
                "1h 36m",
                "2021-04-16",
                "en",
                "https://www.themoviedb.org/t/p/w185/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "https://www.themoviedb.org/movie/804435"
            )
        )

        return movies


    }

    fun generateDummyTvShow(): List<FilmEntity> {
        val show = ArrayList<FilmEntity>()
        show.add(
            FilmEntity(
                "88396",
                "The Falcon and the Winter Soldier",
                7.9,
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                true,
                "50m",
                "2021-03-19",
                "en",
                "https://www.themoviedb.org/t/p/w185/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "https://www.themoviedb.org/tv/88396"
            )
        )

        show.add(
            FilmEntity(
                "95557",
                "Invincible",
                8.9,
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                true,
                "45m",
                "2021-03-26",
                "en",
                "https://www.themoviedb.org/t/p/w185/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "https://www.themoviedb.org/tv/95557"
            )
        )

        show.add(
            FilmEntity(
                "60735",
                "The Flash",
                7.7,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                true,
                "44m",
                "2014-10-07",
                "en",
                "https://www.themoviedb.org/t/p/w185/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "https://www.themoviedb.org/tv/60735"
            )
        )

        show.add(
            FilmEntity(
                "71712",
                "The Good Doctor",
                8.6,
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                true,
                "43m",
                "2017-09-25",
                "en",
                "https://www.themoviedb.org/t/p/w185/z1K4mJwISETia59rrnMdXxzoSrZ.jpg",
                "https://www.themoviedb.org/tv/71712"
            )
        )

        show.add(
            FilmEntity(
                "1416",
                "Grey's Anatomy",
                8.2,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                true,
                "43m",
                "2005-03-27",
                "en",
                "https://www.themoviedb.org/t/p/w185/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "https://www.themoviedb.org/tv/1416"
            )
        )

        return show
    }

    fun generateRemoteDummyMovies(): List<ResultsItemMovie> {

        val movies = ArrayList<ResultsItemMovie>()

        movies.add(
            ResultsItemMovie(
                460465,
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Mortal Kombat",
                "/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                7.7
            )
        )

        movies.add(
            ResultsItemMovie(
                399566,
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "Godzilla vs. Kong",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                8.1
            )
        )

        movies.add(
            ResultsItemMovie(
                615457,
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\\\\\"nobody.\\\\\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "Nobody",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                8.5
            )
        )

        movies.add(
            ResultsItemMovie(
                567189,
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                7.3
            )
        )

        movies.add(
            ResultsItemMovie(
                804435,
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                "Vanquish",
                "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                6.4
            )
        )

        return movies
    }

    fun generateRemoteDummyTvShow(): List<ResultsItemTvShow> {
        val tvShows = ArrayList<ResultsItemTvShow>()

        tvShows.add(
            ResultsItemTvShow(
                88396,
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                7.9,
                "The Falcon and the Winter Soldier",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
            )
        )

        tvShows.add(
            ResultsItemTvShow(
                95557,
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                8.9,
                "Invincible",
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
            )
        )

        tvShows.add(
            ResultsItemTvShow(
                60735,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\\\\\"meta-human\\\\\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                7.7,
                "The Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )

        tvShows.add(
            ResultsItemTvShow(
                71712,
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                8.6,
                "The Good Doctor",
                "/z1K4mJwISETia59rrnMdXxzoSrZ.jpg"
            )
        )

        tvShows.add(
            ResultsItemTvShow(
                1416,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                8.2,
                "Grey's Anatomy",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
            )
        )

        return tvShows
    }

    fun generateRemoteDummyDetailMovie(): DetailMovieResponse {
        return DetailMovieResponse(
            460465,
            "Mortal Kombat",
            "/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
            "2021-04-07",
            "en",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            7.7,
            110
        )
    }

    fun generateRemoteDummyDetailTvShow(): DetailTvShowResponse {
        return DetailTvShowResponse(
            88396,
            "2021-03-19",
            "The Falcon and the Winter Soldier",
            "en",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            7.9,
            listOf()
        )
    }
}