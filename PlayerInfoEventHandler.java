package bowtruckle.mods.gods.data;


import bowtruckle.mods.gods.tools.Settings;
import bowtruckle.mods.gods.tools.Vector3;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Settings.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class PlayerInfoEventHandler {


    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> e) {
        if(e.getObject() instanceof PlayerEntity) {
            PlayerInfoProvider provider = new PlayerInfoProvider();
            e.addCapability(new ResourceLocation(Settings.MODID,"lastPos"), provider);
            e.addListener(provider::invalidate);
        }
    }

    @SubscribeEvent
    public static void onPlayerMove(TickEvent.PlayerTickEvent e) {
        System.out.println("event called");
        if(e.getPhase().equals(TickEvent.Phase.END)) {
            System.out.println("Event Phase End");
            e.player.getCapability(CapabilityPlayerInfo.PLAYER_INFO_CAPABILITY).ifPresent(information -> {
                Vector3 pos = new Vector3(e.player.getPosX(), e.player.getPosY(), e.player.getPosZ());
                if (pos == information.getLastPos()) {
                    e.player.setInvisible(true);
                }else{
                    e.player.setInvisible(false);
                }
                System.out.println(information.getLastPos());
            });
        }
    }
}
