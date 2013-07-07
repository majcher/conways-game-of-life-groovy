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
		
		def newCells = cells.collect { cell -> cell.position }
			.collectEntries { position -> [ (position) : position.neighbours() ] }
			.collectEntries { position, neighbours -> [ (position) : neighbours.findAll( liveNeighbourPredicate ) ] }
			.collectEntries { position, liveNeighbours -> [(position) : liveNeighbours.size()] }
			.collect { position, liveNeighboursSize -> cellAt(position).turnIntoNewState(liveNeighboursSize) }
		
		cells = newCells
	}
	
}
