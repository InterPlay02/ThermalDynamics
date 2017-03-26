package cofh.thermaldynamics.multiblock;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public interface IGridTile<T extends IGridTile<T, G>, G extends MultiBlockGrid<T>> {

	/* GRID FORMATION */
	void setGrid(@Nullable G newGrid);

	G createGrid();

	G getGrid();

	void setInvalidForForming();

	void setValidForForming();

	boolean isValidForForming();

	IGridTile<T, G> getConnectedSide(int side);

	boolean isBlockedSide(int side);

	boolean isSideConnected(byte side);

	// Used to do multiblock steps passed off by the grid. IE: Distribute liquids.
	// return false if the grid has altered
	boolean tickPass(int pass);

	boolean isNode();

	void addRelays();

	/* PASSTHROUGH METHODS */
	void onNeighborBlockChange();

	BlockPos pos();

	World world();

}
