import React, {
    Component,
    PropTypes
} from 'react';
import {
    requireNativeComponent,
    Platform,
    DeviceEventEmitter
} from 'react-native';

import { NativeModules } from 'react-native';

const _module = NativeModules.BaiduGetDistanceModule;

export default {
    getLocationDistance(lat1, lng1, lat2, lng2){
        return new Promise((resolve, reject) => {
            try {
                alert(_module);
                _module.getLocationDistance(lat1, lng1, lat2, lng2);
            }
            catch (e) {
                reject(e);
                return;
            }
            DeviceEventEmitter.once('getDistanceResult', resp => {
                resp.distance = parseFloat(resp.distance);
                resolve(resp);
            });
        });
    },
}