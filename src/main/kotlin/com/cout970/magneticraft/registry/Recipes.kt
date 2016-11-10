package com.cout970.magneticraft.registry

import coffee.cypher.mcextlib.extensions.items.stack
import com.cout970.magneticraft.api.internal.registries.machines.crushingtable.CrushingTableRecipeManager
import com.cout970.magneticraft.api.internal.registries.machines.hydraulicpress.HydraulicPressRecipeManager
import com.cout970.magneticraft.api.internal.registries.machines.hydraulicpress.KilnRecipeManager
import com.cout970.magneticraft.api.internal.registries.machines.tablesieve.HeatExchangerRecipeManager
import com.cout970.magneticraft.api.internal.registries.machines.tablesieve.IceboxRecipeManager
import com.cout970.magneticraft.api.internal.registries.machines.tablesieve.TableSieveRecipeManager
import com.cout970.magneticraft.block.*
import com.cout970.magneticraft.block.decoration.*
import com.cout970.magneticraft.block.fuel.BlockCharcoalSlab
import com.cout970.magneticraft.block.fuel.BlockCoke
import com.cout970.magneticraft.block.heat.*
import com.cout970.magneticraft.block.multiblock.BlockHydraulicPress
import com.cout970.magneticraft.block.multiblock.BlockKiln
import com.cout970.magneticraft.block.multiblock.BlockSolarPanel
import com.cout970.magneticraft.item.*
import com.cout970.magneticraft.item.hammers.ItemIronHammer
import com.cout970.magneticraft.item.hammers.ItemStoneHammer
import com.cout970.magneticraft.util.*
import net.minecraft.block.Block
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.init.Blocks.*
import net.minecraft.init.Items
import net.minecraft.init.Items.*
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fluids.FluidStack
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.oredict.OreDictionary
import net.minecraftforge.oredict.ShapedOreRecipe
import net.minecraftforge.oredict.ShapelessOreRecipe

/**
 * Created by cout970 on 11/06/2016.
 */

/**
 * Called by CommonProxy to register all the recipes in the mod
 */
fun registerRecipes() {
    //@formatter:off

    //CRUSHING TABLE RECIPES
    addCrushingTableRecipe(Items.SKULL.stack(meta = 4), Items.GUNPOWDER.stack(size = 8))
    addCrushingTableRecipe(ItemStack(Blocks.IRON_ORE, 1, 0), ItemCrushedOre.stack(size = 1, meta = 0))
    addCrushingTableRecipe(ItemStack(Blocks.GOLD_ORE, 1, 0), ItemCrushedOre.stack(size = 1, meta = 1))
    addCrushingTableRecipe(ItemStack(BlockOre, 1, 0), ItemCrushedOre.stack(size = 1, meta = 2))
    addCrushingTableRecipe(ItemStack(BlockOre, 1, 1), ItemCrushedOre.stack(size = 1, meta = 3))
    addCrushingTableRecipe(ItemStack(BlockOre, 1, 2), ItemCrushedOre.stack(size = 1, meta = 4))
    addCrushingTableRecipe(ItemStack(BlockOre, 1, 3), ItemCrushedOre.stack(size = 1, meta = 5))
    addCrushingTableRecipe(ItemStack(BlockLimestone, 1, 2), ItemStack(BlockBurntLimestone, 1, 2))

    addCrushingTableRecipe(ItemStack(IRON_INGOT, 1), ItemStack(ItemLightPlate, 1, 0))
    addCrushingTableRecipe(ItemStack(GOLD_INGOT, 1), ItemStack(ItemLightPlate, 1, 1))
    addCrushingTableRecipe(ItemStack(ItemIngot, 1, 2), ItemStack(ItemLightPlate, 1, 2))
    addCrushingTableRecipe(ItemStack(ItemIngot, 1, 3), ItemStack(ItemLightPlate, 1, 3))
    addCrushingTableRecipe(ItemStack(ItemIngot, 1, 4), ItemStack(ItemLightPlate, 1, 4))
    addCrushingTableRecipe(ItemStack(ItemIngot, 1, 5), ItemStack(ItemLightPlate, 1, 5))

    //HYDRAULIC PRESS RECIPES
    addHydraulicPressRecipe(ItemStack(IRON_INGOT, 2), ItemStack(ItemHeavyPlate, 1, 0), 120f)
    addHydraulicPressRecipe(ItemStack(GOLD_INGOT, 2), ItemStack(ItemHeavyPlate, 1, 1), 50f)
    addHydraulicPressRecipe(ItemStack(ItemIngot, 2, 2), ItemStack(ItemHeavyPlate, 1, 2), 100f)
    addHydraulicPressRecipe(ItemStack(ItemIngot, 2, 3), ItemStack(ItemHeavyPlate, 1, 3), 50f)
    addHydraulicPressRecipe(ItemStack(ItemIngot, 2, 4), ItemStack(ItemHeavyPlate, 1, 4), 120f)
    addHydraulicPressRecipe(ItemStack(ItemIngot, 2, 5), ItemStack(ItemHeavyPlate, 1, 5), 150f)

    addHydraulicPressRecipe(ItemStack(BlockLimestone, 4, 2), ItemStack(BlockBurntLimestone, 4, 2), 50f)

    addHydraulicPressRecipe(ItemStack(ItemNugget, 6, 0), ItemStack(ItemLightPlate, 1, 0), 120f)
    addHydraulicPressRecipe(ItemStack(GOLD_NUGGET, 6), ItemStack(ItemLightPlate, 1, 1), 50f)
    addHydraulicPressRecipe(ItemStack(ItemNugget, 6, 2), ItemStack(ItemLightPlate, 1, 2), 100f)
    addHydraulicPressRecipe(ItemStack(ItemNugget, 6, 3), ItemStack(ItemLightPlate, 1, 3), 50f)
    addHydraulicPressRecipe(ItemStack(ItemNugget, 6, 4), ItemStack(ItemLightPlate, 1, 4), 120f)
    addHydraulicPressRecipe(ItemStack(ItemNugget, 6, 5), ItemStack(ItemLightPlate, 1, 5), 150f)

    //KILN RECIPES
    addKilnRecipe(ItemStack(COAL_BLOCK, 1, 0), BlockCoke.defaultState, 50, COKE_REACTION_TEMP, CARBON_SUBLIMATION_POINT)
    addKilnRecipe(ItemStack(Blocks.LOG, 1, 0), BlockCharcoalSlab.defaultState, 25, COKE_REACTION_TEMP, CARBON_SUBLIMATION_POINT)
    addKilnRecipe(ItemStack(Blocks.SAND, 1, 0), Blocks.GLASS.defaultState, 25, GLASS_MAKING_TEMP, QUARTZ_MELTING_POINT)
    addKilnRecipe(ItemStack(Blocks.CLAY, 1, 0), Blocks.HARDENED_CLAY.defaultState, 25, DEFAULT_SMELTING_TEMPERATURE, QUARTZ_MELTING_POINT)
    addKilnRecipe(ItemStack(BlockFluxedGravel), BlockGlazedBrick.defaultState, 25, FURNACE_BRICK_TEMP, QUARTZ_MELTING_POINT)

    //CRAFTING RECIPES

    //nuggets
    addRecipe(ItemStack(ItemNugget, 9, 0), "I", 'I', "ingotIron")
    addRecipe(ItemStack(ItemNugget, 9, 2), "I", 'I', "ingotCopper")
    addRecipe(ItemStack(ItemNugget, 9, 3), "I", 'I', "ingotLead")
    addRecipe(ItemStack(ItemNugget, 9, 4), "I", 'I', "ingotCobalt")
    addRecipe(ItemStack(ItemNugget, 9, 5), "I", 'I', "ingotTungsten")
    //blocks
    addRecipe(ItemStack(BlockCompactedCopper), "iii", "iii", "iii", 'i', ItemStack(ItemIngot, 1, 2))
    addRecipe(ItemStack(BlockCompactedLead), "iii", "iii", "iii", 'i', ItemStack(ItemIngot, 1, 3))
    addRecipe(ItemStack(BlockCompactedCobalt), "iii", "iii", "iii", 'i', ItemStack(ItemIngot, 1, 4))
    addRecipe(ItemStack(BlockCompactedTungsten), "iii", "iii", "iii", 'i', ItemStack(ItemIngot, 1, 5))
    //other
    addRecipe(ItemStack(ItemIronHammer), true, "XX#", "XZX", "#Z#", 'X', "ingotIron", 'Z', "stickWood")
    addRecipe(ItemStack(ItemStoneHammer), true, "XX#", "XZX", "#Z#", 'X', "cobblestone", 'Z', "stickWood")

    addRecipe(ItemStack(BlockLimestone, 4, 1), "XX", "XX", 'X', ItemStack(BlockLimestone, 1, 0))
    addRecipe(ItemStack(BlockTileLimestone, 4, 0), "XY", "YX", 'X', ItemStack(BlockLimestone, 1, 0), 'Y', ItemStack(BlockBurntLimestone, 1, 0))
    addRecipe(ItemStack(BlockBurntLimestone, 4, 1), "XX", "XX", 'X', ItemStack(BlockBurntLimestone, 1, 0))

    addRecipe(ItemStack(BlockFluxedGravel, 4), "CSC", "LGF", "CSC", 'G', "gravel", 'C', Items.CLAY_BALL, 'L', "pebblesLead", 'F', "pebblesCobalt_Mgc", 'S', "sand")

//    addRecipe(ItemStack(ItemGuideBook), "CB", 'C', "ingotCopper", 'B', of(BOOK))
    addRecipe(ItemStack(BlockIncendiaryGenerator), "ICI", "IFI", "IBI", 'I', "ingotIron", 'C', "ingotCopper", 'F', of(FURNACE), 'B', of(BRICK_BLOCK))

    addRecipe(ItemStack(ItemCoilOfWire), "#C#", "C#C", "#C#", 'C', "ingotCopper")
    addRecipe(ItemStack(ItemVoltmeter), "WIW", "PRP", "CPC", 'C', "ingotCopper", 'I', "ingotIron", 'P', "plankWood", 'R', ItemCoilOfWire, 'W', of(WOOL))
    addRecipe(ItemStack(ItemThermometer), "GIG", "PRP", "TPT", 'T', "ingotTungsten", 'I', "ingotIron", 'P', "plankWood", 'R', ItemCoilOfWire, 'G', "blockGlass")

    addRecipe(ItemStack(BlockElectricFurnace), "CCC", "CFC", "CBC", 'C', "ingotCopper", 'F', of(FURNACE), 'B', of(BRICK_BLOCK))
    addRecipe(ItemStack(BlockInfiniteWater), "IBI", "TCT", "IBI", 'C', "ingotCobalt", 'I', "ingotIron", 'T', "ingotTungsten", 'B', Items.WATER_BUCKET)

    addRecipe(ItemStack(BlockMachineBlock, 2), "SSS", "I#I", "PIP", 'I', "ingotLead", 'S', BlockBurntLimestone, 'P', "lightPlateIron")
    addRecipe(ItemStack(BlockHydraulicPress), "PPP", "IMI", "SSS", 'I', "ingotLead", 'S', BlockBurntLimestone, 'P', "lightPlateIron", 'M', BlockMachineBlock)
    addRecipe(ItemStack(BlockMachineBlockSupportColumn, 4), "PSP", "OSO", "PSP", 'O', "lightPlateLead", 'S', BlockBurntLimestone, 'P', "lightPlateIron")
    addRecipe(ItemStack(BlockStripedMachineBlock, 8), "YSB", "S#S", "BSY", 'Y', "dyeYellow", 'S', BlockBurntLimestone, 'B', "dyeBlack")

    addRecipe(ItemStack(BlockBattery), "ILI", "CPC", "LCL", 'I', "lightPlateIron", 'P', ItemCoilOfWire, 'L', "lightPlateLead", 'C', "ingotCobalt")
    addRecipe(ItemStack(BlockElectricPoleAdapter), "INI", "IPI", "ICI", 'I', "lightPlateIron", 'P', ItemCoilOfWire, 'N', BlockElectricConnector, 'C', "ingotCopper")
    addRecipe(ItemStack(BlockElectricConnector, 8), "#C#", "WLW", "SSS", 'C', "ingotCopper", 'W', of(WOOL), 'S', of(STONE_SLAB), 'L', "ingotLead")
    addRecipe(ItemStack(BlockAirLock), "TCT", "PSP", "TCT", 'C', "heavyPlateCobalt", 'T', "ingotTungsten", 'P', ItemCoilOfWire, 'S', of(SPONGE))

    addRecipe(ItemStack(BlockTableSieve), "SPS", "I#I", "WWW", 'W', "plankWood", 'I', "ingotIron", 'P', of(PAPER), 'S', "slabWood")
    addRecipe(ItemStack(BlockCrushingTable), "SSS", "WWW", "W#W", 'S', of(STONE_SLAB), 'W', "logWood")
    addRecipe(ItemStack(BlockKiln), "BDB", "BPB", 'B', BlockBurntLimestone, 'P', "lightPlateCopper", 'D', Items.IRON_DOOR)
    addRecipe(ItemStack(BlockFeedingTrough), "M#M", "SWS", 'S', "stickWood", 'W', "plankWood", 'M', "slabWood")

    addRecipe(ItemStack(BlockElectricPole), "CPC", "#W#", "#W#", 'P', "plankWood", 'C', BlockElectricConnector, 'W', "logWood")
    addRecipe(ItemStack(BlockSolarPanel), "LCL", "I#I", "IPI", 'L', "lightPlateLead", 'C', ItemCoilOfWire, 'I', "lightPlateIron", 'P', "heavyPlateIron")
    addRecipe(ItemStack(BlockElectricalMachineBlock), "III", "PWP", "III",  'I', "ingotIron", 'P', "lightPlateIron", 'W', ItemCoilOfWire)

    addRecipe(ItemStack(BlockElectricHeater), "XPX", "XFX", "XFX", 'P', "lightPlateCopper", 'F', ItemCoilOfWire, 'X', "ingotBrick")
    addRecipe(ItemStack(BlockBrickFurnace), "XXX", "XFX", "XPX", 'X', "ingotBrick", 'P', "lightPlateCopper", 'F', Blocks.FURNACE)
    addRecipe(ItemStack(BlockFirebox), "XPX", "XFX", "XXX", 'X', "ingotBrick", 'P', "lightPlateCopper", 'F', Blocks.FURNACE)
    addRecipe(ItemStack(BlockIcebox), "XXX", "XFX", "XPX", 'X', "cobblestone", 'P', "lightPlateCopper", 'F', Items.CAULDRON)
    addRecipe(ItemStack(BlockHeatReservoir), "XPX", "XFX", "XXX", 'X', "ingotBrick", 'P', "lightPlateCopper", 'F', BlockCompactedCopper)
    addRecipe(ItemStack(BlockHeatSink), "PPP", "XPX", 'X', "ingotBrick", 'P', "lightPlateCopper")
    addRecipe(ItemStack(BlockHeatPipe, 8), "BBB", "PIP", "BBB", 'B', "ingotBrick", 'P', "lightPlateCopper", 'I', "ingotCopper")

    addRecipe(ItemStack(BlockCoke), "XXX", "XXX", "XXX", 'X', of(ItemCoke))
    addRecipe(ItemStack(ItemCoke, 9), "###", "#X#", "###", 'X', of(BlockCoke))

    //ICEBOX RECIPES
    addIceboxRecipeWater(ItemStack(Items.SNOWBALL), 125, false)
    addIceboxRecipeWater(ItemStack(Blocks.SNOW), 500, false)
    addIceboxRecipeWater(ItemStack(Blocks.ICE), 900, true)
    addIceboxRecipeWater(ItemStack(Blocks.PACKED_ICE), 1000, false)

    //SMELTING RECIPES
    addSmeltingRecipe(ItemStack(BlockBurntLimestone, 1, 0), ItemStack(BlockLimestone, 1, 0))
    addSmeltingRecipe(ItemStack(BlockBurntLimestone, 1, 2), ItemStack(BlockLimestone, 1, 2))
    //ores
    addSmeltingRecipe(ItemStack(ItemIngot, 1, 2), ItemStack(BlockOre, 1, 0))
    addSmeltingRecipe(ItemStack(ItemIngot, 1, 3), ItemStack(BlockOre, 1, 1))
    addSmeltingRecipe(ItemStack(ItemIngot, 1, 4), ItemStack(BlockOre, 1, 2))
    addSmeltingRecipe(ItemStack(ItemIngot, 1, 5), ItemStack(BlockOre, 1, 3))
    //pebles
    addSmeltingRecipe(ItemStack(Items.IRON_INGOT, 2, 0), ItemStack(ItemPebbles, 1, 0))
    addSmeltingRecipe(ItemStack(Items.GOLD_INGOT, 2, 0), ItemStack(ItemPebbles, 1, 1))
    addSmeltingRecipe(ItemStack(ItemIngot, 2, 2), ItemStack(ItemPebbles, 1, 2))
    addSmeltingRecipe(ItemStack(ItemIngot, 2, 3), ItemStack(ItemPebbles, 1, 3))
    addSmeltingRecipe(ItemStack(ItemIngot, 2, 4), ItemStack(ItemPebbles, 1, 4))
    addSmeltingRecipe(ItemStack(ItemIngot, 2, 5), ItemStack(ItemPebbles, 1, 5))
    //crushed ores
    addSmeltingRecipe(ItemStack(Items.IRON_INGOT, 1, 0), ItemStack(ItemCrushedOre, 1, 0))
    addSmeltingRecipe(ItemStack(Items.GOLD_INGOT, 1, 0), ItemStack(ItemCrushedOre, 1, 1))
    addSmeltingRecipe(ItemStack(ItemIngot, 1, 2), ItemStack(ItemCrushedOre, 1, 2))
    addSmeltingRecipe(ItemStack(ItemIngot, 1, 3), ItemStack(ItemCrushedOre, 1, 3))
    addSmeltingRecipe(ItemStack(ItemIngot, 1, 4), ItemStack(ItemCrushedOre, 1, 4))
    addSmeltingRecipe(ItemStack(ItemIngot, 1, 5), ItemStack(ItemCrushedOre, 1, 5))

    //TABLE SIEVE RECIPES
    for (i in ItemPebbles.variants.keys) {
        addTableSieveRecipe(ItemStack(ItemCrushedOre, 1, i), ItemStack(ItemPebbles, 1, i), ItemStack(COBBLESTONE), 0.15f)
    }

    //@formatter:on
}

private fun addRecipe(result: ItemStack, vararg craft: Any) {
    GameRegistry.addRecipe(ShapedOreRecipe(result, *craft))
}

private fun addShapelessRecipe(result: ItemStack, vararg craft: Any) {
    GameRegistry.addRecipe(ShapelessOreRecipe(result, *craft))
}

private fun addSmeltingRecipe(result: ItemStack, input: ItemStack) {
    GameRegistry.addSmelting(input, result, 0.1f) // i don't care about xp
}

private fun addCrushingTableRecipe(input: ItemStack, output: ItemStack) {
    CrushingTableRecipeManager.registerRecipe(CrushingTableRecipeManager.createRecipe(input, output, true))
}

private fun addHeatExchangerRecipe(input: FluidStack, output: FluidStack, heat: Long, minTemp: Double, maxTemp: Double, reverseLow: Boolean, reverseHigh: Boolean) {
    HeatExchangerRecipeManager.registerRecipe(HeatExchangerRecipeManager.createRecipe(input, output, heat, minTemp, maxTemp, reverseLow, reverseHigh))
}

private fun addTableSieveRecipe(input: ItemStack, output0: ItemStack, output1: ItemStack, prob: Float) {
    TableSieveRecipeManager.registerRecipe(TableSieveRecipeManager.createRecipe(input, output0, output1, prob, true))
}

private fun addHydraulicPressRecipe(input: ItemStack, output: ItemStack, ticks: Float) {
    HydraulicPressRecipeManager.registerRecipe(HydraulicPressRecipeManager.createRecipe(input, output, ticks, true))
}

private fun addKilnRecipe(input: ItemStack, output: ItemStack, duration: Int, minTemp: Double, maxTemp: Double) {
    KilnRecipeManager.registerRecipe(KilnRecipeManager.createRecipe(input, output, duration, minTemp, maxTemp, true))
}

private fun addKilnRecipe(input: ItemStack, output: IBlockState, duration: Int, minTemp: Double, maxTemp: Double) {
    KilnRecipeManager.registerRecipe(KilnRecipeManager.createRecipe(input, output, duration, minTemp, maxTemp, true))
}

private fun addIceboxRecipe(input: ItemStack, output: FluidStack, heat: Long, specificHeat: Double, minTemp: Double, maxTemp: Double, reverse: Boolean) {
    IceboxRecipeManager.registerRecipe(IceboxRecipeManager.createRecipe(input, output, heat, specificHeat, minTemp, maxTemp, reverse))
}

private fun addIceboxRecipeWater(input: ItemStack, output: Int, reverse: Boolean) {
    IceboxRecipeManager.registerRecipe(IceboxRecipeManager.createRecipe(input, FluidStack(FluidRegistry.WATER, output), (WATER_HEAT_OF_FUSION * output / 1000).toLong(), WATER_HEAT_CAPACITY, WATER_MELTING_POINT, WATER_BOILING_POINT, reverse))
}

//function to get the first ore dictionary entry for the block if exist, or the block if not exist
private fun of(i: Block): Any {
    val ids = OreDictionary.getOreIDs(ItemStack(i))
    if (ids.isEmpty()) return i
    return OreDictionary.getOreName(ids.first())
}

//function to get the first ore dictionary entry for the item if exist, or the item if not exist
private fun of(i: Item): Any {
    val ids = OreDictionary.getOreIDs(ItemStack(i))
    if (ids.isEmpty()) return i
    return OreDictionary.getOreName(ids.first())
}