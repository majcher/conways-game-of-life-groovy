package pl.mmajcherski.gameoflife

class Universe {

	private Set<Cell> cells = new HashSet<Cell>();
	
	def add(Cell cell) {
		cells.add(cell);
	}
	
	def Cell cellAt(Position searchPosition) {
		cells.find { cell -> 
			cell.position == searchPosition;
		}
	}
	
	def tick() {
		def liveNeighbourPredicate = { neighbour ->
			cellAt(neighbour) instanceof LiveCell
		}
		
		cells = cells.collectEntries { cell -> [ (cell) : cell.position.neighbours() ] }
			.collectEntries { cell, neighbours -> [ (cell) : neighbours.findAll( liveNeighbourPredicate ) ] }
			.collectEntries { cell, liveNeighbours -> [(cell) : liveNeighbours.size()] }
			.collect { cell, liveNeighboursSize -> cell.nextCellStateForLiveNeighboursCount(liveNeighboursSize) }
	}
	
}
