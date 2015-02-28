GameOfLifeUpgraded
===================

[Problem description](http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
---------------------

The Rules
---------

> For a space that is *'populated'*:
   + Each cell with one or no neighbors dies, as if by loneliness. 
   +  Each cell with four or more neighbors dies, as if by overpopulation. 
   +  Each cell with two or three neighbors survives. 

> For a space that is *'empty'* or *'unpopulated'*
   +  Each cell with three neighbors becomes populated. 

Plan
----

> ###LifeController

> ###Grid
    #### public interactions
     - seed(positionstolive)
     - forwardToNextGeneration()

    #### private interactions
     - getNeighbours(cell)
     - forwardAllCellsToNextGeneration()
     - getNextGenerationLifeStatus(cell)

> ###AIEngine
    #### public interactions
     - computeNextGeneration(board)

    #### private interactions
    ##### *for living cell*
     - isUnderPopulated(cell)
     - isOverCrowded(cell)
     - isAliveForNextGeneration(cell)
    ##### *for empty cell*
     - isReadyForReproduction()

> ###Cell
    #### public interactions
     - hasLife()
     - setLifeForNextGeneration()
     - forwardToNextGeneration()