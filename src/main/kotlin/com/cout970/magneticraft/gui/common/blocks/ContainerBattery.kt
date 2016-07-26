package com.cout970.magneticraft.gui.common.blocks

import coffee.cypher.mcextlib.extensions.worlds.getTile
import com.cout970.magneticraft.gui.common.ContainerBase
import com.cout970.magneticraft.gui.common.DATA_ID_CHARGE_RATE
import com.cout970.magneticraft.gui.common.DATA_ID_STORAGE
import com.cout970.magneticraft.gui.common.DATA_ID_VOLTAGE
import com.cout970.magneticraft.tileentity.electric.TileBattery
import com.cout970.magneticraft.util.misc.IBD
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.items.SlotItemHandler

/**
 * Created by cout970 on 11/07/2016.
 */
class ContainerBattery(player: EntityPlayer, world: World, blockPos: BlockPos) : ContainerBase(player, world, blockPos) {

    val tile = world.getTile<TileBattery>(blockPos)

    init {
        val inv = tile?.inventory
        inv?.let {
            addSlotToContainer(SlotItemHandler(inv, 0, 102, 16))
            addSlotToContainer(SlotItemHandler(inv, 1, 102, 48))
        }
        bindPlayerInventory(player.inventory)
    }

    override fun transferStackInSlot(playerIn: EntityPlayer?, index: Int): ItemStack? = null

    override fun sendDataToClient(): IBD? {
        val data = IBD()
        tile!!
        data.setDouble(DATA_ID_VOLTAGE, tile.mainNode.voltage)
        data.setInteger(DATA_ID_STORAGE, tile.storage)
        data.setFloat(DATA_ID_CHARGE_RATE, tile.chargeRate.average)
        return data
    }

    override fun receiveDataFromServer(ibd: IBD) {
        tile!!
        ibd.getDouble(DATA_ID_VOLTAGE, { tile.mainNode.voltage_ = it })
        ibd.getInteger(DATA_ID_STORAGE, { tile.storage = it })
        ibd.getFloat(DATA_ID_CHARGE_RATE, { tile.chargeRate.storage = it })
    }
}