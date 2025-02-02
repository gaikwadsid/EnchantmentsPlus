**IMPORTANT: As of 3.0.0 the project requires Java 11 or above to run, use the 2.x.x LTS versions instead if you use Java 8**

Got a question? Need help or want to discuss changes? Then feel free to contact me either via [Email](mail-to:admin@geolykt.de), [Spigotmc conversations](https://www.spigotmc.org/conversations/add) or Github [Issues](https://github.com/Geolykt/EnchantmentsPlus/issues) and [Discussions](https://github.com/Geolykt/EnchantmentsPlus/discussions). Issues however should be reported here on Github so forkers can profit from them being public, but it's the best if at least someone (me in most cases) knows exploits or bugs so they can be fixed, so in the end it doesn't really matter where they are reported to.

# Enchantments+
## Description
Enchantments+ is a hard fork of Zenchantments, a custom enchantments plugin adding 73 enchantments of all variants, including target-tracing arrows, lumber axes, block-breaking lasers, and much more. They are obtained through the normal enchantment process and act like regular enchantments, capable of being combined and merged (on paper-based server software). The plugin requires no client-side mods or resource packs. A comprehensive configuration file enables fine-tuning of individual enchantments to tailor them to every server's gameplay. 
The hard fork status however means that we won't maintain any parity with Zenchantments; this is because there are too many differences with the plugin that it is pretty much impossible to convert the 174 commits from Zenchantment's development branch into EnchantmentsPlus-compatible commits.

## Enchantments+ vs other Zenchantments forks
  - This fork is actively maintained and has persisted since May of 2020, which is the longer than any other fork who are otherwise more shortlived.
  - This is fast(-ish). During the last months the fork accumulated lots of revisions that aim at improving performance as well as general code quality. It also continues to do so with each update.
  - Enchantments+ doesn't use NMS. This means that newer minecraft versions are supported at a bigger scale than otherwise is the case, however with Zenchantments remvoing it's multi-version support, this may no longer be full selling point.
  - The fork is stable, while there are some bugs, most are either really obscure or noone reported them to me. If they are reported, they will often be fixed in under a day (especially on github).
  - EnchantmentsPlus 3+.x.x requires Java 11 (or higher) in order to compile and run, Zenchantments runs on Java 8, so if you have an older JVM, use Zenchantments instead
  - EnchantmentsPlus 4+.x.x (currently only planned) will make use of the Paper api for even more performance

## Metrics
As of version 2.1.6 the plugin uses bstats to cover metrics, the page where the information is shown can be found [here](https://bstats.org/plugin/bukkit/EnchantmentsPlus/9211).
Please do not opt out of Metrics as it will only come back to bite you! Changes that are introduced to the plugin may be based on the metrics.

## Permissions
<b>enchplus.enchant.get</b> - On player enchant event, allow player to have a chance at the enabled custom enchantments<br>
<b>enchplus.enchant.use</b> - Allow player to use the given custom enchants on an item<br>
<b>enchplus.command.reload</b> - Access to /ench reload, to reload the configuration (try not to use, may lead to memory leaks)<br>
<b>enchplus.command.give</b> - Gives an enchanted item, while similar to enchant, it also gives the underlying material<br>
<b>enchplus.command.list</b> - Lists all availiable enchantments<br>
<b>enchplus.command.info</b> - Returns the info of an enchantments<br>
<b>enchplus.command.onoff</b> - Abillity to turn on / turn off a certain enchantment<br>
<b>enchplus.command.enchant</b> - Enchants a item without giving the underlying material. Also allows to enchant other people's stuff, so be cautious.<br>
<b>enchplus.command.lasercol</b> - Enables the abillity to colo(u)r the laser of your item in hand. Purely cosmetic and a good way to get a few extra "donations".<br>

## Commands
**/ench help**: Prints the help menu <br>
**/ench version**: prints the version of the plugin <br>
**/ench info**: Prints the information of all the enchantments on your current tool <br>
**/ench info &lt;enchantment&gt;**: Prints the information about a single enchantment <br>
**/ench list**: Returns the list of the applicable enchantments for the tool in your hand <br>
**/ench give &lt;player&gt; &lt;material&gt; &lt;enchantment&gt;**: Gives the player a given material with the given enchantment at level 1 <br>
**/ench give &lt;player&gt; &lt;material&gt; &lt;enchantment&gt; &lt;level&gt;**: Gives the player a given material with the given enchantment at the given level <br>
**/ench lasercol &lt;col&gt;**: Chages the tone of the laser used by the laser enchantment, per tool. <br>
**/ench &lt;enchantment&gt;**: Enchants your tool in the hand with the given enchantment at level 1. <br>
**/ench &lt;enchantment&gt; &lt;level&gt;**: Enchants your tool in the hand with the given enchantment at the given level. <br>
**/ench &lt;enchantment&gt; &lt;level&gt; &lt;modifier&gt;**: Like above, but the third parameter dictates for who the enchantment should be applied (accepts things such as @a) <br>
**/ench &lt;enchantment&gt; &lt;level&gt; &lt;modifier&gt; &lt;doNotification&gt;**: Like above, but the fourth parameter handles whether or not chat messages should be send as a error/success message. (use True or false) <br>
**/ench &lt;enchantment&gt; &lt;level&gt; &lt;modifier&gt; &lt;doNotification&gt; &lt;force&gt;**: Like above, but the fith parameter handles whether the enchantment should be forced onto the tool. (use True or false) <br>

## Obtaining
See [Releases](https://github.com/Geolykt/EnchantmentsPlus/releases) for downloads
Or compile this project like every other project out there via maven and a JDK 11 or higher, a "mvn clean package" should suffice to build the plugin.

## Compatibility
The current version of this plugin is compatible with Spigot version 1.15.2, 1.16.1, 1.16.2, 1.16.3, 1.16.4, 1.16.5. Any versions under 1.15.2, will **not** work without tinkering, versions above 1.16.5, may, although with a few issues.
We however recommend Paper for full compatibillity. If you are using spigot, please consider enabling the `1xx-anvil-merger` option in the patches.yml.

## Contribute
Anyone is free to contribute to this repository via pull requests, issues or comments, however keep in mind that this repository uses 4 space indentation.
If you feel like compliaining about performance while not being an annoying person, then please send me profiling reports NOT TIMINGS.
I cannot do much with Timings and I require proper profiling reports to optimize the plugin, otherwise I'm guessing where the bottlenecks COULD be (and usually they are not where I search them).

## Changes performed in this fork compared to NMS-less Zenchantments
To view the changes compared to Zenchantments (from the point where the split happened), add the Changelog of [NMS-Less Zenchantments](https://github.com/Geolykt/NMSless-Zenchantments#changes-performed-in-this-fork) onto it
The current EnchantmentsPlus API is however entirely incompatible with the new Zenchantments API in almost every way.
<ul>
 <li>Major changes:
  <ul>
   <li>Pretty big rewrites within most classes (Enchantment specific classes are mostly spared)</li>
   <li>Most values in the compatibillity adapter can be changed via magic configuration files now</li>
   <li>The Spectral enchantment can now be levelled by default</li>
   <li>Uses the 1.16.3 Spigot API</li>
   <li>2 more enchantment getters</li>
  </ul>
 </li>
 <li>Minor changes:
  <ul>
   <li>Fixed the Reveal enchantment, with it's own twist</li>
   <li>Added an enchantment gatherer denylist - only works with NBT and advLore right now</li>
   <li>The color of the laser can now be changed for purely costmetical reasons. Why? Don't ask</li>
   <li>Help and tab completion now handle permissions</li>
   <li>Mystery fish can now catch other water mobs such as cod, pufferfish and salmon and was buffed overall</li>
   <li>Admins can now change which items are part of which tool</li>
   <li>Added metrics system</li>
  </ul>
 </li>
 <li>Patches:
  <ul>
   <li>Fire enchantment no longer OOMs when attempting to smelt unsmeltable stuff</li>
   <li>Added toggleable shred cooldown when the laser enchantment is used</li>
   <li>Fixed potential bug with the vortex enchantment, the specifics are unknown</li>
   <li>Mitigated severe lag issues with the Spectral enchantment, also performed some optimisations. To get to the pervious way of how the enchantment worked, put the enchantment power to really high values</li>
   <li>Spectral now can use it's own Protection system nullifying the risk of McMMO/Jobs exploits</li>
   <li>Spectral performance increased noticeably</li>
   <li>Lots of performance improvements for periodically running tasks</li>
   <li>Dispensing laser items no longer temporarily freezes the Server</li>
   <li>Grindstone works properly in a few more cases now</li>
   <li>Spectral arrows can now be used!</li>
  </ul>
 </li>
 <li>Code changes (doesn't affect behaviour as much):
  <ul>
   <li>Refractored to it's own structure</li>
   <li>Fix compilation issues with later bindings</li>
   <li>Changed the way permissions are handled within the code</li>
   <li>Removed ClassGraph as a dependency</li>
   <li>Minimal usage of ItemStack#getItemMeta, which is a very expensive call. This should increase the performance by a noticable amount</li>
  </ul>
 </li>
</ul>
