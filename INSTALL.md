Installing ChatFix
------------------

Before installing ChatFix, ensure that you have done all of the requirements:

1. You have installed ModLoader (http://bit.ly/snQajN) to minecraft.jar, 
and have ensured that it works.
2. You have deleted META-INF/ from minecraft.jar
3. You are competent enough to provide useful error messages if it breaks.

Congratulations! You're ready to install ChatFix!

Installing
----------

ChatFix can be installed the standard method, by patching minecraft.jar.
However, due to the configuration file, it requires a bit more work. To install
using this method, do the following steps:

1. Download ChatFix and unzip it. Chances are you've already done that.
2. In the ChatFix-build/ChatFix/ folder, copy the chatfix/ folder and all
of its contents into minecraft.jar. (If you don't know how to do this, there is
a handy guide at http://bit.ly/v9Ymqz on how to install mods)
3. In the ChatFix-build folder, copy the ChatFix folder and all its
contents to the .minecraft/mods directory. 
4. In the .minecraft/mods directory, delete the entire chatfix/ folder

The minecraft directory structure should look something like this:

    .minecraft/
      bin/
      mods/
        ChatFix/
          Configuration.yml
      resources/
      saves/
      stats/
      texturepacks/
