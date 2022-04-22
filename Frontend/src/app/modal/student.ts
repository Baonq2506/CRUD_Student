import {Profile } from '../modal/profile';
import { Subject } from './Subject';

export class Student {
        public id: string;
        public name: string;
        public age: string;
        public address: string;
        public phone: string;
        public image: File;
        public profile: Profile;
        public class_id: string;
        public subjects : Subject[];
}