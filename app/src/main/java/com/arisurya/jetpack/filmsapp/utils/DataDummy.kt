package com.arisurya.jetpack.filmsapp.utils

import com.arisurya.jetpack.filmsapp.data.MovieEntity
import com.arisurya.jetpack.filmsapp.data.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                "M1",
                "A Star Is Born",
                7.5,
                "2h 16m",
                "2018-10-5",
                "English",
                "A country music star whose career is starting to fade, Jackson Maine (Bradley Cooper) discovers a very talented talent in a young musician named Ally (Lady Gaga). Maine managed to orbit Ally into a promising young star. But the two of them are involved in a relationship that goes beyond just mentors and students. As Ally and himself skyrocketed, Maine ran into a dilemma regarding this matter.",
                "https://www.themoviedb.org/t/p/w1280/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "https://www.themoviedb.org/movie/332562-a-star-is-born"
            )
        )

        movies.add(
            MovieEntity(
                "M2",
                "Alita: Battle Angel",
                7.2,
                "2h 2m",
                "2019-2-14",
                "English",
                "When Alita awakens with no memories of who she is in a future world she doesn't know, she is captured by Ido, a compassionate doctor who realizes that somewhere in the shell of this abandoned cyborg is the heart and soul of an extraordinary young woman.",
                "https://www.themoviedb.org/t/p/w1280/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "https://www.themoviedb.org/movie/399579-alita-battle-angel"
            )
        )
        movies.add(
            MovieEntity(
                "M3",
                "Aquaman",
                6.9,
                "2h 23m",
                "2018-12-21",
                "English",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://www.themoviedb.org/t/p/w1280/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                "https://www.themoviedb.org/movie/297802-aquaman"
            )
        )
        movies.add(
            MovieEntity(
                "M4",
                "Bohemian Rhapsody",
                8.0,
                "2h 15m",
                "2018-11-2",
                "English",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet - finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/t/p/w1280/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "https://www.themoviedb.org/movie/424694-bohemian-rhapsody"
            )
        )
        movies.add(
            MovieEntity(
                "M5",
                "Cold Pursuit",
                5.7,
                "1h 59m",
                "2019-2-8",
                "English",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "https://www.themoviedb.org/t/p/w1280/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "https://www.themoviedb.org/movie/438650-cold-pursuit"
            )
        )
        movies.add(
            MovieEntity(
                "M6",
                "Creed II",
                6.9,
                "2h 10m",
                "2018-11-21",
                "English",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "https://www.themoviedb.org/t/p/w1280/qPQFWrLoQYyGxmeBgmpX901Q0mF.jpg",
                "https://www.themoviedb.org/movie/480530-creed-ii"
            )
        )
        movies.add(
            MovieEntity(
                "M7",
                "Crimes Grindelwald",
                6.9,
                "2h",
                "2018-11-16",
                "English",
                "Gellert Grindelwald has escaped from prison and has begun gathering followers towards his goal - exalting witches above all non-magical creatures. The only one who can stop him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the witch who thwarted Grindelwald earlier, his former student, Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among true friends and family, in an increasingly divided wizarding world.",
                "https://www.themoviedb.org/t/p/w1280/7IgyMP3YDAPt2PFqu50UcVqqRlG.jpg",
                "https://www.themoviedb.org/movie/338952-fantastic-beasts-the-crimes-of-grindelwald"
            )
        )
        movies.add(
            MovieEntity(
                "M8",
                "Glass",
                6.7,
                "2h 9m",
                "2019-1-18",
                "English",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds critical secrets to both men.",
                "https://www.themoviedb.org/t/p/w1280/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "https://www.themoviedb.org/movie/450465-glass"
            )
        )
        movies.add(
            MovieEntity(
                "M9",
                "How to Train Your Dragon",
                7.8,
                "1h 44m",
                "2019-1-9",
                "English",
                "When Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless' discovery of an untested and elusive partner drives Night Fury away. As the danger increases in the house and Hiccup's reign as village chief is put to the test, both the dragon and the rider must make the impossible decision to save their kind.",
                "https://www.themoviedb.org/t/p/w1280/bCYRgsT0Kndh23a6kHazBdXWCn1.jpg",
                "https://www.themoviedb.org/movie/166428-how-to-train-your-dragon-3"
            )
        )
        movies.add(
            MovieEntity(
                "M10",
                "Avengers: Infinity War",
                8.3,
                "2h 29m",
                "2018-4-27",
                "English",
                "As the Avengers and their allies continue to protect the world from threats too big for a single hero to handle, a new danger has emerged from the cosmic shadow: Thanos. An intergalactic blasphemy despot, his goal is to collect all six Infinity Stones, an unimaginable power artifact, and use them to inflict a twisted will on all realities. Everything the Avengers have fought for has evolved to date - Earth's fate and existence itself have never been more certain.",
                "https://www.themoviedb.org/t/p/w1280/ksBQ4oHQDdJwND8H90ay8CbMihU.jpg",
                "https://www.themoviedb.org/movie/299536-avengers-infinity-war"
            )
        )
        movies.add(
            MovieEntity(
                "M11",
                "Overload",
                6.7,
                "1h 50m",
                "2018-11-9",
                "English",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realize that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "https://www.themoviedb.org/t/p/w1280/2Sfo3O54kTAAnBfZaCXrwimORSo.jpg",
                "https://www.themoviedb.org/movie/438799-overlord"
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {
        val show = ArrayList<TvShowEntity>()
        show.add(
            TvShowEntity(
                "T1",
                "The Arrow",
                6.6,
                "42m",
                "2012-10-10",
                "English",
                "Arrows is a retelling of the adventures of the legendary DC hero Green Arrow",
                "https://www.themoviedb.org/t/p/w1280/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://www.themoviedb.org/tv/1412-arrow"
            )
        )
        show.add(
            TvShowEntity(
                "T2",
                "Doom Patrol",
                7.6,
                "49m",
                "2019-2-15",
                "English",
                "The Doom Patrol's members each horrible accidents that gave them superhuman abilities - but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence - and to protect Earth from what they find.",
                "https://www.themoviedb.org/t/p/w1280/nclcURTdlqVbDr6HPmrHC5X4qUu.jpg",
                "https://www.themoviedb.org/tv/79501-doom-patrol"
            )
        )
        show.add(
            TvShowEntity(
                "T3",
                "Supergirl",
                7.3,
                "42m",
                "2015-10-26",
                "English",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "https://www.themoviedb.org/t/p/w1280/vqBsgL9nd2v04ZvCqPzwtckDdFD.jpg",
                "https://www.themoviedb.org/tv/62688-supergirl"
            )
        )
        show.add(
            TvShowEntity(
                "T4",
                "The Umbrella Academy",
                8.7,
                "55m",
                "2019-2-14",
                "English",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "https://www.themoviedb.org/t/p/w1280/uYHdIs5O8tiU5p6MvUPd2jElOH6.jpg",
                "https://www.themoviedb.org/tv/75006-umbrella-academy"
            )
        )
        show.add(
            TvShowEntity(
                "T5",
                "Flash",
                7.7,
                "44m",
                "2014-10-7",
                "English",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Several months later he awakens with the power of superhuman speed, giving him the ability to move through Central City like an invisible guardian angel. Although initially delighted by his new powers, Barry is surprised to find that he is not the only \"meta-human\" created after the accelerator explosion - and not everyone is using their new powers for good. Barry partnered with S.T.A.R. Lab and dedicate his life to protecting the innocent. For now, only a few close friends and associates know that Barry is literally the fastest human being, but it won't be long before the world finds out what Barry Allen ... The Flash is all about.",
                "https://www.themoviedb.org/t/p/w1280/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "https://www.themoviedb.org/tv/60735-the-flash"
            )
        )
        show.add(
            TvShowEntity(
                "T6",
                "The Simpsons",
                7.8,
                "22m",
                "1989-12-17",
                "English",
                "Set in Springfield, America's average city, this show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as thousands of virtual players. Since its inception, the series has become a pop culture icon, drawing hundreds of celebrities to guest appearances. The show has also become famous for its fearless satire on political life, the media, and America in general.",
                "https://www.themoviedb.org/t/p/w1280/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "https://www.themoviedb.org/tv/456-the-simpsons"
            )
        )
        show.add(
            TvShowEntity(
                "T7",
                "Shameless",
                8.0,
                "57m",
                "2011-1-9",
                "English",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be ... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "https://www.themoviedb.org/t/p/w1280/m2gf7SYOq9z30Q1dJFMF51DfrmF.jpg",
                "https://www.themoviedb.org/tv/34307-shameless"
            )
        )
        show.add(
            TvShowEntity(
                "T8",
                "Grey's Anatomy",
                8.2,
                "43m",
                "2005-2-27",
                "English",
                "Follow the personal and professional lives of a group of doctors at the Gray Sloan Memorial Hospital in Seattle.",
                "https://www.themoviedb.org/t/p/w1280/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "https://www.themoviedb.org/tv/1416-grey-s-anatomy"
            )
        )
        show.add(
            TvShowEntity(
                "T9",
                "Hanna",
                7.5,
                "50m",
                "2019-3-28",
                "English",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "https://www.themoviedb.org/t/p/w1280/qjQWlL4CcjPdgw3f9o7jguXN97A.jpg",
                "https://www.themoviedb.org/tv/54155-hanna"
            )
        )
        show.add(
            TvShowEntity(
                "T10",
                "Family Guy",
                7.0,
                "22m",
                "1999-2-31",
                "English",
                "The sick, twisted and wrong animated animated series Freakin 'Sweet, features the adventures of the dysfunctional Griffin family. Clumsy Peter and long-suffering Lois have three children. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and most unpopular girl in town) and Chris (middle child, she is not very smart but has a passion for movies). The last member of the family is Brian - a talking dog and more than just a pet, he looks after Stewie, while sipping Martinis and sorting out his own life problems.",
                "https://www.themoviedb.org/t/p/w1280/q3E71oY6qgAEiw6YZIHDlHSLwer.jpg",
                "https://www.themoviedb.org/tv/1434-family-guy"
            )
        )
        show.add(
            TvShowEntity(
                "T11",
                "Marvel's Iron Fist",
                6.6,
                "55m",
                "2017-33-17",
                "English",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "https://www.themoviedb.org/t/p/w1280/9sYiKhHzfO1zhbVS2XID3gFe6Kx.jpg",
                "https://www.themoviedb.org/tv/62127-marvel-s-iron-fist"
            )
        )
        return show
    }
}