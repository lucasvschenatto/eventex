import {address} from "../address/address";

export class Event {
    id: string;
    name: string;
    description: string;
    date: string;
    time: string;
    place: string;
    address: address;
}