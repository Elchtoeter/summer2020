#!/usr/bin/env python

import os
import shutil
from glob import glob


if __name__ == '__main__':
    grpNr = int(input("Enter grp number:")) - 1
    files = sorted(glob('*.zip')+glob('*.rar'))
    nrItems = len(files)
    chunkSize = nrItems/6
    rest = nrItems % 6
    if grpNr < rest:
        listStart = grpNr * (chunkSize+1)
        listEnd = (chunkSize+1) + (grpNr * (chunkSize+1))
    else:
        listStart = ((chunkSize+1)*rest) + (grpNr*chunkSize)
        listEnd = chunkSize + (((chunkSize+1)*rest) + (grpNr*chunkSize))
    filesBefore = files[:listStart]
    selectedFiles = files[listStart:listEnd]
    filesAfter = files[listEnd:]
    restFiles = filesBefore + filesAfter
    currentDirectory = os.getcwd()
    rest_directory = os.path.join(currentDirectory, r'_Rest')
    korr_directory = os.path.join(currentDirectory, r'_Korrekturen')
    done_directory = os.path.join(currentDirectory, r'_Done')
    os.makedirs(rest_directory)
    os.makedirs(korr_directory)
    os.makedirs(done_directory)
    for f in restFiles:
        shutil.move(f, rest_directory)
