package com.cout970.magneticraft.network

import com.cout970.magneticraft.gui.common.ContainerBase
import com.cout970.magneticraft.util.IBD
import io.netty.buffer.ByteBuf
import net.minecraft.client.Minecraft
import net.minecraftforge.fml.common.network.simpleimpl.IMessage
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext
import net.minecraftforge.fml.relauncher.Side

/**
 * Created by cout970 on 10/07/2016.
 */

//Server -> Client
class MessageIBD() : IMessage {

    var ibd: IBD? = null

    constructor(ibd: IBD?) : this() {
        this.ibd = ibd
    }

    override fun fromBytes(buf: ByteBuf?) {
        val ibd = IBD()
        ibd.fromBuffer(buf!!)
        this.ibd = ibd
    }

    override fun toBytes(buf: ByteBuf?) {
        ibd!!.toBuffer(buf!!)
    }

    companion object : IMessageHandler<MessageIBD, IMessage>{

        override fun onMessage(message: MessageIBD?, ctx: MessageContext?): IMessage? {
            if(ctx!!.side == Side.CLIENT) {
                val container = Minecraft.getMinecraft().thePlayer.openContainer
                if (container is ContainerBase) {
                    container.receiveDataFromServer(message!!.ibd!!)
                }
            }else{
                throw IllegalStateException()
            }
            return null
        }
    }
}