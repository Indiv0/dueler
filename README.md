# dueler
[![Travis CI](https://secure.travis-ci.org/MinerAp/dueler.png)](http://travis-ci.org/#!/MinerAp/dueler)
[![Coverage Status](https://img.shields.io/coveralls/MinerAp/dueler.svg)](https://coveralls.io/r/MinerAp/dueler?branch=master)

A Bukkit plugin that allows players to challenge each other to duels in arenas.

## Outline ##

PersonA types `/duel PersonB` or `/duel PersonB Arena1`, then the plugin teleports them to an empty arena (or `Arena1`).

Players must accept the duel for the duel to work.

Arena locations are specified with the plugin, using `/dueler create NAME [type]`.

Duels last until players die.

The only arenas players are allowed to join while a duel is in progress are FFA arenas.
