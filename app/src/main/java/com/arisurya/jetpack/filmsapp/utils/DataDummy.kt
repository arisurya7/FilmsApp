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

        movies.add(
            FilmEntity(
                "635302",
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                8.4,
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                false,
                "1h 57m",
                "2020-10-16",
                "en",
                "https://www.themoviedb.org/t/p/w185/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                "https://www.themoviedb.org/movie/635302"
            )
        )

        movies.add(
            FilmEntity(
                "632357",
                "The Unholy",
                5.7,
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                false,
                "1h 39m",
                "2021-03-31",
                "en",
                "https://www.themoviedb.org/t/p/w185/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                "https://www.themoviedb.org/movie/632357"
            )
        )

        movies.add(
            FilmEntity(
                "726684",
                "Miraculous World: Shanghai – The Legend of Ladydragon",
                7.8,
                "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time.",
                false,
                "52m",
                "2021-04-04",
                "fr",
                "https://www.themoviedb.org/t/p/w185/msI5a9TPnepx47JUb2vl88hb80R.jpg",
                "https://www.themoviedb.org/movie/726684"
            )
        )

        movies.add(
            FilmEntity(
                "527774",
                "Raya and the Last Dragon",
                8.2,
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                false,
                "1h 47m",
                "2021-03-03",
                "en",
                "https://www.themoviedb.org/t/p/w185/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "https://www.themoviedb.org/movie/527774"
            )
        )

        movies.add(
            FilmEntity(
                "791373",
                "Zack Snyder's Justice League",
                8.5,
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                false,
                "3h 2m",
                "2021-03-18",
                "en",
                "https://www.themoviedb.org/t/p/w185/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "https://www.themoviedb.org/movie/791373"
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

        show.add(
            FilmEntity(
                "97180",
                "Selena: The Series",
                7.5,
                "As Mexican-American Tejano singer Selena comes of age and realizes her dreams, she and her family make tough choices to hold on to love and music.",
                true,
                "40m",
                "2020-12-04",
                "en",
                "https://www.themoviedb.org/t/p/w185/mYsWyfiIMxx4HDm0Wck7oJ9ckez.jpg",
                "https://www.themoviedb.org/tv/97180"
            )
        )

        show.add(
            FilmEntity(
                "79008",
                "Luis Miguel: The Series",
                8.0,
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                true,
                "- m",
                "2005-03-27",
                "en",
                "https://www.themoviedb.org/t/p/w185/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "https://www.themoviedb.org/tv/79008"
            )
        )

        show.add(
            FilmEntity(
                "69478",
                "The Handmaid's Tale",
                8.2,
                "Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship. A TV adaptation of Margaret Atwood's novel.",
                true,
                "50m",
                "2017-04-26",
                "en",
                "https://www.themoviedb.org/t/p/w185/oIkxqt6ug5zT5ZSUUyc1Iqopf02.jpg",
                "https://www.themoviedb.org/tv/69478"
            )
        )

        show.add(
            FilmEntity(
                "63174",
                "Lucifer",
                8.5,
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                true,
                "45m",
                "2016-01-25",
                "en",
                "https://www.themoviedb.org/t/p/w185/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "https://www.themoviedb.org/tv/63174"
            )
        )

        show.add(
            FilmEntity(
                "69050",
                "Riverdale",
                8.6,
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                true,
                "45m",
                "2017-01-26",
                "en",
                "https://www.themoviedb.org/t/p/w185/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "https://www.themoviedb.org/tv/69050"
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