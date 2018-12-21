![Spotify Wrapper](lib/SpotifyWrapper.png)

**Its Getting 2019! Happy New Year For Everyone!**

# SpotifyWrapper
This is an open sourced project to analyze Spotify Downloaded Data and this software not affiliated to any of Spotify Ltd software's or products

This readme will be updated from time to time, for your eyes comfort :P

### What is this project?

Do you always listen to all of your favourite musics on Spotify and
you don't even know what you like to listens to? This software
allows you to know what you been listening into, how long you been listening with Spotify
or what's your favourite artist that you enjoy listens to.

Of course Spotify has already this technique but for those who willing to
see what is your results. Feel free to enjoy this.

Take note that **this is not a Music Player**. This reads out
your Spotify Privacy data which you could take it out from your [Spotify Privacy Section](https://www.spotify.com/us/account/privacy/).
**We will never collect any piece of your valuable information.** Trust me, All my friends are using this software too.


### Spotify Archives.

For now, we had detected some changes from what Spotify does from last 6 month ago (June).
Please take a note that some features may not be perfectly works. You could takeout a
new data from [Spotify Privacy Section](https://www.spotify.com/us/account/privacy/) and use it as your archive to be read.

From what we know, these are the differences:

Version 1:
```json
[
  {
    "artistName" : "Piero, ALIUS, Denzal Park",
    "trackName" : "When We Were Young (feat. ALIUS) - Denzal Park Edit",
    "time" : "2018-03-17 06:54:24"
  },
  {
    "artistName" : "Piero, ALIUS, Denzal Park",
    "trackName" : "When We Were Young (feat. ALIUS) - Denzal Park Edit",
    "time" : "2018-03-17 06:58:21"
  },
  {
    "artistName" : "Selena Gomez, Felix Cartal, Antonina Armato, Selena Gomez, Dave Audé, Benny Blanco, T. Price, Rock Mafia, Antonina Armato, Benny Blanco, Selena Gomez, Dave Audé, Benny Blanco, T. Price",
    "trackName" : "Kill Em With Kindness - Felix Cartal Remix",
    "time" : "2018-03-17 07:01:34"
  },
  {
    "artistName" : "Claudia Leitte, Daddy Yankee, Antonio Rayo Gibo, Beatriz Luengo, Yotuel Romero, Raymond Ayala, Derrus Rachel, Rayito, Antonio Rayo Gibo, Beatriz Luengo, Yotuel Romero, Raymond Ayala, Derrus Rachel",
    "trackName" : "Corazón",
    "time" : "2018-03-17 07:26:24"
  }
]
```

Version 2:
```json
[
  {
    "endTime" : "2018-09-24 07:44",
    "artistName" : "American Authors",
    "trackName" : "Pocket Full Of Gold",
    "msPlayed" : 32896
  },
  {
    "endTime" : "2018-09-24 08:34",
    "artistName" : "Seum Dero",
    "trackName" : "Again",
    "msPlayed" : 220255
  },
  {
    "endTime" : "2018-09-24 08:37",
    "artistName" : "Marcus Mouya",
    "trackName" : "Blushin' Around You",
    "msPlayed" : 195254
  },
  {
    "endTime" : "2018-09-24 08:40",
    "artistName" : "Tribe Dive & Rivo",
    "trackName" : "Breakdown",
    "msPlayed" : 179722
  }
]
```

**See any different?**, Well this could be inaccurate as we still didn't know how
does this data supposed to look like during April till October, so its recommended for you
to not use any of your old downloaded archives.

### Does it ready yet for production?

Of course it's not ready yet, There is some stuff need to be finished such as GUI (Graphical User Interface),
Multithreaded calculations, Image manipulations, and some other cool stuff.

Any issues regarding this repository will be **Closed** unless the issue is very heavy.

PS: The author love Imagine Dragons ;)
