package me.apeiros.aetherexpansion.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.experimental.UtilityClass;
import me.apeiros.aetherexpansion.AetherExpansion;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.markdown.DiscordFlavor;
import net.kyori.adventure.text.minimessage.transformation.TransformationType;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

@UtilityClass
public class Utils {

    // MiniMessage
    private static final MiniMessage m = MiniMessage.builder()
            .markdown()
            .markdownFlavor(DiscordFlavor.get())
            .removeDefaultTransformations()
            .transformation(TransformationType.COLOR)
            .transformation(TransformationType.DECORATION)
            .transformation(TransformationType.GRADIENT)
            .transformation(TransformationType.CLICK_EVENT)
            .transformation(TransformationType.HOVER_EVENT)
            .build();

    // MiniMessage parse methods
    public static Component parse(String s) { return m.parse(s); }

    public static String legacyParse(String s) { return LegacyComponentSerializer.legacySection().serialize(parse(s)); }

    // Enchant
    public static ItemStack ench(ItemStack item, Map<Enchantment, Integer> e) {
        item.addUnsafeEnchantments(e);
        return item;
    }

    public static SlimefunItemStack ench(SlimefunItemStack item, Map<Enchantment, Integer> e) {
        item.addUnsafeEnchantments(e);
        return item;
    }

    // Shine enchant
    public static SlimefunItemStack shine(SlimefunItemStack item) {
        item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        item.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return item;
    }

    // Key
    public static NamespacedKey key(String s) {
        return new NamespacedKey(AetherExpansion.i(), s);
    }

}