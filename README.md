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


Iteration 1
=============
review comments
===============

 - native array should be avoided
 - encapsulate how input is given
 - exception should not expose internals of the system. it should be user perspective
 - read me - should expose how to run or use the code but should not describe the system itself
 - Make constants and messages in a separate class for more readability
 - Encapsulate the rules

Extension
----------
 - cell has age.
 - default age is 3
 - whenever cell is suffers from under population or over population age will get reduced by 1
 - if a cell continously lives for 3 generation with same age. it age increases by 1

Steps to proceed:
-----------------
 - refactor the existing code
 - make interface for the rules
 - extract messages constants
 - do the extension
