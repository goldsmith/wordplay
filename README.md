# Wordplay

API for cheating at word games, written in Clojure.

## Endpoints

All endpoints return pretty-printed JSON by default.

### GET /words/:word	
	
Get a serialized representation of a word resource

	{
  		"word" : wordplay",
  		"game": "wwf"
   		"length" : 8,
  		"letters" : [ "w", "o", "r", "d", "p", "l" "a", "y" ],
  		"is_valid" : true,
  		"points": 17,
  		"anagrams": [],
  		"definition": ""
	} 
	
Query parameters:

| Parameter     | Optional?  | Description                                                                             |
| :-----------: |:----------:| :---------------------------------------------------------------------------------------|
| game          | yes        | The alias of the board game to look the word up in. See *Supported Games* for more info |


### GET /board

Get a ``board`` resource, with computed properties like ``best_move``. Wordplay is stateless, so you must pass in all information about a board's state for each request.

	{
		"tiles": [][],
		"rack": [],
		"game": "wwf",
		"best_move": {},
		"remaining_letters": [],
		"words": []	
	}

Query parameters:

| Parameter     | Optional?  | Description                                                                               |
| :-----------: |:----------:| :---------------------------------------------------------------------------------------- |
| game          | yes        | The alias of the board game to look the word up in. See *Supported Games* for more info   |
| tiles         | no         | A 2D array ([row][column]) of tiles, each either one character or a blank denoted by "_". |                                | rack          | yes        | A list of tiles in the player's rack. If empty, no "best_move" will be present.           |



#### Supported games

| Game               | Alias   | Default? |
| :----------------- | -----   | -------- |
| Words with Friends | ``wwf`` | yes      |


## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server
    
## Future

Supported games:

 * Words with Friends/Scrabble
 * Crossword
 * Word ladder?

## License

Copyright © 2014 Jonathan Goldsmith
