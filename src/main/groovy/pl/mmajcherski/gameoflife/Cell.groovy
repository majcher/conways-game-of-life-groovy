package pl.mmajcherski.gameoflife

import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;

@EqualsAndHashCode
@ToString
abstract class Cell {

	Position position
	
	protected Cell(Position position) {
		this.position = position;
	}
	
	abstract def Cell nextCellStateForLiveNeighboursCount(int liveNeighboursCount)

}
