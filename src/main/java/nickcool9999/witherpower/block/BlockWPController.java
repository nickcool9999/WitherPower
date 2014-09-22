package nickcool9999.witherpower.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nickcool9999.witherpower.network.WPowerController;

public class BlockWPController extends Block {
	public BlockWPController() {
		super(Material.anvil);
		this.setResistance(14000000.0F);
		this.setHardness(1.0F);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	public TileEntity createTileEntity(World world, int metadata)
	{
	   return new WPowerController();
	}
}
